window.onload = function() {

    var edit = false; //bool used for simple switch on cog, false for view, true for edit

    var records = JSON.parse(localStorage.getItem("records"))
    if (!records) {
        records = {
            "bs" : 250,
            "bp" : 195,
            "fs" : 200,
            "sp" : 140
        }
    }

    var bsDisplay = document.getElementById("bs-value")
    var bpDisplay = document.getElementById("bp-value")
    var fsDisplay = document.getElementById("fs-value")
    var spDisplay = document.getElementById("sp-value")
    var cog = document.getElementById("cog")


    cog.onclick = function () { switchModes(!edit) }

    // function to switch with cog button between view and edit modes
    function switchModes(editMode) {
        edit = editMode
        if (editMode) {
            bsDisplay.innerHTML = `<input type="number" class="w-32 bg-lace mb-2 outline-falu border-falu border-2 text-center" value="${records.bs}" id="bs-input"/>`
            bpDisplay.innerHTML = `<input type="number" class="w-32 bg-lace mb-2 outline-falu border-falu border-2 text-center" value="${records.bp}" id="bp-input"/>`
            fsDisplay.innerHTML = `<input type="number" class="w-32 bg-lace mb-2 outline-falu border-falu border-2 text-center" value="${records.fs}" id="fs-input"/>`
            spDisplay.innerHTML = `<input type="number" class="w-32 bg-lace mb-2 outline-falu border-falu border-2 text-center" value="${records.sp}" id="sp-input"/>`
        } else {

            records.bs = document.getElementById("bs-input").value
            records.bp = document.getElementById("bp-input").value
            records.fs = document.getElementById("fs-input").value
            records.sp = document.getElementById("sp-input").value

            localStorage.setItem("records", JSON.stringify(records))
            
            displayValues()
        }
    }

    function displayValues() {
        bsDisplay.innerHTML = records.bs
        bpDisplay.innerHTML = records.bp
        fsDisplay.innerHTML = records.fs
        spDisplay.innerHTML = records.sp
    }

    displayValues()
}