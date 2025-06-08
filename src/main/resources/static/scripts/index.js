// Submit login form and redirect according to user type
function loginRedirect(event) {
	event.preventDefault();

	const form = event.target;
	const formData = new FormData(form);

	// Send POST request and manage server response
	fetch("/login", {
            method: "POST",
            body: formData,
        })
        .then((responseData) => {
			if (responseData.ok) {
				return responseData.json();
			} else {
                return responseData.json().then((error) => {
					throw error;
				});
            }
        })
        .then((responseData) => {
			alert("Login successful!");
			if (responseData.role === "ROLE_Farmer") {
				window.location.href = "welcomeF";
			} else {
				window.location.href = "welcomeR";
			}
		})
        .catch((responseError) => {
			
            // Manage server failure response
			alert("Invalid credentials.");
        });

	return false;
}

// Submit signup form
function handleSignUp(event) {
    event.preventDefault();

  	const userType = document.querySelector('input[name="newUserType"]:checked').value;
    const username = document.querySelector('input[name="newUsername"]').value;
    const email = document.querySelector('input[name="newEmail"]').value;
    const password = document.querySelector('input[name="newPassword"]').value;

	const formBody = {
			userType: userType,
            username: username,
            email: email,
            password: password,
    };
	const requestHeaders = {"Content-Type": "application/json"};

	// Send POST request and manage server response
	fetch("/api/signup", {
		method: "POST",
		headers: requestHeaders,
		body: JSON.stringify(formBody),
	})
	.then((responseData) => {
		if (responseData.ok) {
			return responseData.json();
		} else {
			return responseData.json().then((error) => {
				throw error;
			});
		}
	})
	.then((responseData) => {
		alert("Sign-up successful!");
		document.getElementById('signupModal').style.display = 'none';
	})
	.catch((responseError) => {

		// Manage server failure response
		 alert(responseError.message);
	});
}

