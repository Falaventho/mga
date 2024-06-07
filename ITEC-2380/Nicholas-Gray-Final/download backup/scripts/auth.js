let authToken = getAuthToken()
let mockToken = "7a5f3e432913752e9013778281cee754"
let mockLogin = {
    "email" : "test@test.com",
    "password" : "helloworld"
}


var homePath = './index.html'
var loginPath = './login.html'
// ! Replace above paths with public folder relative paths


function checkAuth() {
    if (!authToken) {
        authToken = getAuthToken()
    }
    if (authToken && authToken == mockToken) {
        return true
    } else {
        return false
    }
}

function getAuthToken() {
    return localStorage.getItem("auth_token")
}

function setAuthToken(token) {
    if (token === String(token)) {
        localStorage.setItem("auth_token", token)
    } else {
        console.log("Invalid token type, failed to save to LocalStorage.")
    }
}

function login() {

    event.preventDefault()

    let email = document.getElementById("email-input").value
    let password = document.getElementById("password-input").value

    console.log(email, password)

    if (email === mockLogin.email && password === mockLogin.password) {
        setAuthToken(mockToken);
        redirect("home");
    } else {
        console.log("Failed to log in, invalid email or password.")
    }
}

function guestLogin() {
    setAuthToken(mockToken)
    redirect("home")
}

function redirect(target) {
    if (target === "home") {
        window.location.href = homePath
    } else if (target === "login") {
        window.location.href = loginPath
    }
}

function onLoadAuthCheck() {
    checkAuth() ?  console.log("auth check completed") : redirect("login")
}

function onLoadAuthCheckBypassLogin() {
    checkAuth() ? redirect("home") : console.log("auth check failed")
}
