window.onload = function () {
    
    var bsInput = document.getElementById("bs-input")
    var bpInput = document.getElementById("bp-input")
    var fsInput = document.getElementById("fs-input")
    var spInput = document.getElementById("sp-input")
    var dateInput = document.getElementById("date-input")
    var buttonCreate = document.getElementById("button-create")

    dateInput.addEventListener('input', function(e){
        var day = new Date(this.value).getUTCDay();
        if([1,2,3,4,5,6].includes(day)){
          e.preventDefault();
          this.value = '';
          alert('You must choose a sunday!');
        }
      });

    buttonCreate.onclick = function () {

        

        let bs = bsInput.value
        let bp = bpInput.value
        let fs = fsInput.value
        let sp = spInput.value
        let date = dateInput.value

        
        if (date == "" || bs <= 0 || bp <= 0 || fs <= 0 || sp <= 0) {
            alert("You must fill out all sections!")
            console.log(dateInput.selectedDate)
        } else {
            planData = {
                "bs" : bs,
                "a1" : ["Calves", "Core"],
                "bp" : bp,
                "a2" : ["Arms", "Back"],
                "fs" : fs,
                "a3" : ["Calves", "Core"],
                "sp" : sp,
                "a4" : ["Arms", "Back"],
                "bsi" : 10,
                "bpi" : 5,
                "fsi" : 10,
                "spi" : 5,
                "start" : new Date('July 15, 2023')
            }

            if (date) {
                planData.start = new Date(date)
            }

            localStorage.setItem("planData", JSON.stringify(planData))

            window.location.href = "./schedule.html"
        }
           
    }

    function getData() {
        planData = JSON.parse(localStorage.getItem("planData"))

        if (!planData) {
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

        bsInput.value = planData.bs
        bpInput.value = planData.bp
        fsInput.value = planData.fs
        spInput.value = planData.sp
        
    }


    getData()
}