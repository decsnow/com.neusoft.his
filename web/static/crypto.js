function encryptPassword() {
    let passwordInput = document.getElementById("password");
    let encryptedPasswordInput = document.getElementById("encryptedPassword");

    // Get the password value
    let password = passwordInput.value;

    // Encrypt the password using SHA-256
    let encryptedPassword;
    encryptedPassword = CryptoJS.SHA256(password).toString();

    // Set the encrypted password value to the hidden input field
    encryptedPasswordInput.value = encryptedPassword;

    // Clear the password input field for security
    passwordInput.value = '';
}