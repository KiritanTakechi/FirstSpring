function buttonAction(action, method) {
    const form = document.getElementById('register-form');
    form.action = action;
    form.method = method;
    form.submit();
}