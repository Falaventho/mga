window.onload = function() {

    var buttonLeft = document.getElementById("button-left")
    var buttonLeftAlt = document.getElementById("button-left-alt")
    var buttonRight = document.getElementById("button-right")
    var buttonRightAlt = document.getElementById("button-right-alt")
    
    var buttonSunday = document.getElementById("button-sunday")
    var buttonMonday = document.getElementById("button-monday")
    var buttonTuesday = document.getElementById("button-tuesday")
    var buttonWednesday = document.getElementById("button-wednesday")
    var buttonThursday = document.getElementById("button-thursday")
    var buttonFriday = document.getElementById("button-friday")
    var buttonSaturday = document.getElementById("button-saturday")
    var dayView = "monday"

    var exercise = document.getElementById("exercise")
    var set1 = document.getElementById("set1")
    var set2 = document.getElementById("set2")
    var set3 = document.getElementById("set3")

    var accessories = document.getElementById("accessories")

    var displayDate = document.getElementById("displayDate")
    var shift = 0
    var offset = (24*60*60*1000*7) // Magic number for 7 day shift (button press)
        
    buttonMonday.onclick = function () { setDay("monday") }
    buttonSunday.onclick = function () { setDay("sunday") }
    buttonTuesday.onclick = function () { setDay("tuesday") }
    buttonWednesday.onclick = function () { setDay("wednesday") }
    buttonThursday.onclick = function () { setDay("thursday") }
    buttonFriday.onclick = function () { setDay("friday") }
    buttonSaturday.onclick = function () { setDay("saturday") }

    buttonLeft.onclick = function () {
        shift -= 1
        updateDate()
        refreshDayView()
    }

    buttonLeftAlt.onclick = function () {
        shift -= 1
        updateDate()
        refreshDayView()
    }

    buttonRight.onclick = function () {
        shift += 1
        updateDate()
        refreshDayView()
    }

    buttonRightAlt.onclick = function () {
        shift += 1
        updateDate()
        refreshDayView()
    }


    var planData = JSON.parse(localStorage.getItem("planData"))
    if (!planData) {
        // check for localdata first, fallback to the default data below
        // ! This is not ORM, but TRM, ensure conversion in planner script
        planData = {
            "bs" : 250,
            "a1" : ["Calves", "Core"],
            "bp" : 180,
            "a2" : ["Arms", "Back"],
            "fs" : 225,
            "a3" : ["Calves", "Core"],
            "sp" : 140,
            "a4" : ["Arms", "Back"],
            "bsi" : 10,
            "bpi" : 5,
            "fsi" : 10,
            "spi" : 5,
            "start" : new Date('July 16, 2023')
        }
    }

    var basePercentages = [.65, .70, .75, .40]

    var shiftReps = [
        [5,5,5],
        [3,3,3],
        [5,3,1],
        [5,5,5]
    ]

    function updateDate() {
        dateTime = new Date(planData.start).getTime()
        let date = new Date
        date.setTime(dateTime + (shift * offset))
        displayDate.innerHTML = `${date.getMonth() + 1} / ` + `${date.getDate() + 1}`
    }

    function refreshDayView() {
        let block = (shift - (shift % 4)) / 4
        let remShift = shift % 4
        let reps = shiftReps[remShift]
        if (dayView == "sunday" || dayView == "saturday" || dayView == "wednesday") {
            setExerciseCol("Rest Day", "None")
            setAccessoryCol([])
        } else if (dayView == "monday") {
            let baseWeight = (parseInt(planData.bs) + (planData.bsi * block))
            setExerciseCol("Back Squat", round5(basePercentages[remShift] * baseWeight), round5((basePercentages[remShift] + .1) * baseWeight), round5((basePercentages[remShift] + .2) * baseWeight), reps)
            setAccessoryCol(planData.a1)
        } else if (dayView == "tuesday") {
            let baseWeight = (parseInt(planData.bp) + (planData.bpi * block))
            setExerciseCol("Bench Press", round5(basePercentages[remShift] * baseWeight), round5((basePercentages[remShift] + .1) * baseWeight), round5((basePercentages[remShift] + .2) * baseWeight), reps)
            setAccessoryCol(planData.a2)
        } else if (dayView == "thursday") {
            let baseWeight = (parseInt(planData.fs) + (planData.fsi * block))
            setExerciseCol("Front Squat", round5(basePercentages[remShift] * baseWeight), round5((basePercentages[remShift] + .1) * baseWeight), round5((basePercentages[remShift] + .2) * baseWeight), reps)
            setAccessoryCol(planData.a3)
        } else if (dayView == "friday") {
            let baseWeight = (parseInt(planData.sp) + (planData.spi * block))
            setExerciseCol("Strict Press", round5(basePercentages[remShift] * baseWeight), round5((basePercentages[remShift] + .1) * baseWeight), round5((basePercentages[remShift] + .2) * baseWeight), reps)
            setAccessoryCol(planData.a4)
        }
    }

    function setExerciseCol(main, s1="", s2="", s3="", reps=["","",""]) {
            exercise.innerHTML = main
            if (main == "Rest Day") {
                set1.innerHTML = s1
                set2.innerHTML = ""
                set3.innerHTML = ""
            } else {
                set1.innerHTML = `${reps[0]} x ${s1}`
                set2.innerHTML = `${reps[1]} x ${s2}`
                set3.innerHTML = `${reps[2]} x ${s3}`
            }
    }

    function setAccessoryCol(exercises) {
        accessories.innerHTML = ""
        for (let i = 0; i < exercises.length; i++) {
            accessories.innerHTML += `<h3 class="flex justify-center bg-lace pt-1 px-4 rounded-md border-2 border-falu w-64 h-12 text-center text-4xl mx-auto mb-4  2xl:text-2xl xl:text=xl lg:text-lg md:text-base sm:text-xs xl:w-min xl:h-min whitespace-nowrap">${exercises[i]}</h3>`
        }
    }

    function round5(x)
    {
        return Math.ceil(x / 5) * 5;
    }

    function setDay(day) {
        let pressed, old
        if (day != dayView) {
            if (day == "sunday") {
                pressed = buttonSunday
            } else if (day == "monday") {
                pressed = buttonMonday
            } else if (day == "tuesday") {
                pressed = buttonTuesday
            } else if (day == "wednesday") {
                pressed = buttonWednesday
            } else if (day == "thursday") {
                pressed = buttonThursday
            } else if (day == "friday") {
                pressed = buttonFriday
            } else if (day == "saturday") {
                pressed = buttonSaturday
            }

            pressed.classList.remove("bg-lace")
            pressed.classList.remove("text-falu")
            pressed.classList.add("bg-falu")
            pressed.classList.add("text-jonquil")
            pressed.classList.add("border-jonquil")

            if (dayView == "sunday") {
                old = buttonSunday
            } else if (dayView == "monday") {
                old = buttonMonday
            } else if (dayView == "tuesday") {
                old = buttonTuesday
            } else if (dayView == "wednesday") {
                old = buttonWednesday
            } else if (dayView == "thursday") {
                old = buttonThursday
            } else if (dayView == "friday") {
                old = buttonFriday
            } else if (dayView == "saturday") {
                old = buttonSaturday
            }
 
            old.classList.remove("bg-falu")
            old.classList.remove("text-jonquil")
            old.classList.remove("border-jonquil")
            old.classList.add("bg-lace")
            old.classList.add("text-falu")

            dayView = day
            
            refreshDayView()
        }
    }

    setDay("sunday")
    updateDate()
}