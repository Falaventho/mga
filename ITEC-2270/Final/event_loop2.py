from graphics import *

def handleClick(pt, win):
    # create an Entry for user to type in
    entry = Entry(pt, 10)
    entry.draw(win)

    # Go modal: loop until user types Return key
    while True:
        key = win.getKey()
        if key == "Return":
            break
    # undraw the entry and create and draw Text
    entry.undraw()
    typed = entry.getText()
    Text(pt, typed).draw(win)

    # clear (ignore) any mouse click that occurred   
    #   during text entry
    win.checkMouse()


def main():
    win = GraphWin("Click and Type", 500, 500)
    # Event Loop: handle key presses and mouse clicks until user
    #    presses the "q" key.
    while True:
        key = win.checkKey()
        if key == "q": # loop exit
            break
        if key:
            handleKey(key, win)
        pt = win.checkMouse()
        if pt:
            handleClick(pt, win)
    win.close()

main()