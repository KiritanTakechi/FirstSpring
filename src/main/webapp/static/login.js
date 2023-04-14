function buttonAction(action, method) {
    const form = document.getElementById('login-form');
    form.action = action;
    form.method = method;
    form.submit();
}