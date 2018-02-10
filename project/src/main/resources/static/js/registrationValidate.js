function showError(container, errorMessage) {
    container.className = 'error';
    var msgElem = document.createElement('span');
    msgElem.className = "error-message";
    msgElem.innerHTML = errorMessage;
    container.appendChild(msgElem);
}

function resetError(container) {
    container.className = '';
    if (container.lastChild.className === "error-message") {
        container.removeChild(container.lastChild);
    }
}



function validate(registrationForm) {
    var elems = registrationForm.elements;
    var validateBoolean = true;

    resetError(elems.name.parentNode);
    var filterName = /[a-z A-Z а-я А-Я]/;
    if (!elems.name.value) {
        validateBoolean = false;
        showError(elems.name.parentNode, ' Укажите имя.');
    } else if (!filterName.test(elems.name.value)) {
        validateBoolean = false;
        showError(elems.name.parentNode, ' В имени не допускаются цифры и символы.');
    }

    resetError(elems.password.parentNode);
    if (!elems.password.value) {
        validateBoolean = false;
        showError(elems.password.parentNode, ' Укажите пароль.');
    } else if (elems.password.value !== elems.password2.value) {
        validateBoolean = false;
        showError(elems.password.parentNode, ' Пароли не совпадают.');
    }

    resetError(elems.login.parentNode);
    var filterLogin = /[a-z A-Z 1-9]/;
    if (!elems.login.value) {
        validateBoolean = false;
        showError(elems.login.parentNode, ' Укажите логин.');
    } else if (!filterLogin.test(elems.login.value)) {
        validateBoolean = false;
        showError(elems.login.parentNode, ' Только латинские буквы и цифры.');
    }

    resetError(elems.surname.parentNode);
    var filterSurname = /[a-z A-Z а-я А-Я]/;
    if (!elems.surname.value) {
        validateBoolean = false;
        showError(elems.surname.parentNode, ' Укажите фамилию.');
    } else if (!filterSurname.test(elems.surname.value)) {
        validateBoolean = false;
        showError(elems.surname.parentNode, ' В Фамилии не допускаются цифры и символы.');
    }


    resetError(elems.email.parentNode);
    var filter = /^([a-zA-Z0-9_\.\-])+@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!elems.email.value) {
        validateBoolean = false;
        showError(elems.email.parentNode, ' Укажите email.');
    }else if (!filter.test(elems.email.value)) {
        validateBoolean = false;
        showError(elems.email.parentNode, ' Укажите корректный email формата anything@anything.any');
    }


    resetError(elems.age.parentNode);
    if (!elems.age.value) {
        validateBoolean = false;
        showError(elems.age.parentNode, ' Укажите возраст.');
    }else if (elems.age.value < 1 || elems.age.value > 120) {
        validateBoolean = false;
        showError(elems.age.parentNode, ' Укажите корректный возраст.');
    }


    if (validateBoolean === true) {
        registrationForm.submit();
    }
}