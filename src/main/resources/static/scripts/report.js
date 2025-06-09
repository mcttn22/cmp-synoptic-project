let reportForm = document.querySelector('form');
let formInfo = document.querySelector('.formPara');

// Form Fields
let firstName = document.querySelector('#nameSubmitted');
let lastName = document.querySelector('#surnameSubmitted');
let email = document.querySelector('#emailSubmitted');
let blockAddress = document.querySelector('#blockAddress');
let description = document.querySelector('#commentsSubmitted');

// Triggers when user submits report
reportForm.addEventListener('submit',(e) => {

    e.preventDefault();

    if (firstName.value && lastName.value && email.value && blockAddress.value && description.value) {

        const formBody = {

            firstName:firstName.value,
            lastName:lastName.value,
            email:email.value,
            blockAddress:blockAddress.value,
            description:description.value

        };

        const requestHeaders = {

            "Content-Type": "application/json"

        };

        fetch('/api/reportissue', {

            method: 'POST',
            headers: requestHeaders,
            body: JSON.stringify(formBody),

        })

        .then(response => response.json())
        .then((responsedata) => {

            console.log(responsedata);
            formInfo.textContent = responsedata.message
			alert("Issue successfully reported!");

        })

    } 

    else {
        formInfo.textContent = "Error: Please fill out the required fields!";
    }

})
