
class Item {
    constructor(id = "", name) {
        if (id == "") {
            this.id = Date.now().toString() + Math.random(32)
        } else {
            this.id = id
        }
        this.name = name
    }
}

todoList = [
    {
        id: "16889967572340.07694737534753981",
        name: "Complete Web Dev Final"
    },
    {
        "id": "16889972413420.42853692590953374",
        "name": "Find Waldo"
    },
    {
        "id": "16889972392810.6784001007904608",
        "name": "Read That One Book"
    },
    {
        "id": "16889972403610.5348414185836912",
        "name": "Test Cake Veracity"
    },
]

function redraw() {
    document.querySelector('#tasks').innerHTML = '';
    for (let i = 0; i < todoList.length; i++) {
        document.querySelector('#tasks').innerHTML += `
                <div class="flex flex-row justify-between mx-8 my-2">
                <div></div>
                    <span id="${todoList[i].id}" class="text-blush text-xl font-copyfont">
                        ${todoList[i].name}
                    </span>
                    <button class="delete bg-red-500 border-2 border-darkraisin hover:scale-110 w-8 h-8 rounded-2xl text-darkraisin font-copyfont" onclick="deleteTask(${todoList[i].id})">
                    X
                    </button>
                </div>
            `
    }
}

function initList() {
    redraw()
}

function createNewItem() {
    taskin = document.getElementById("taskin")
    addItem("", taskin.value)
    taskin.value = ""
    redraw();
}

function addItem(id, name) {
    todoList.push(new Item(id, name))
}

function deleteTask(id) {
    console.log("deleting")
    for (let i = 0; i < todoList.length; i++) {
        if (todoList[i].id == id) {
            console.log(`found id of ${id}`)
            todoList.splice(i, 1)
            redraw()
        }
    }
}

initList()

