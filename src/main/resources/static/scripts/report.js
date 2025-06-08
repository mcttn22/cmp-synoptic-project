let myForm = document.querySelector('form');  // Form element
let myName = document.querySelector('#nameSubmitted');  // Name input
let mySurname = document.querySelector('#surnameSubmitted'); //surname input 
let myEmail = document.querySelector('#emailSubmitted');  // Email input
let message = document.querySelector('#commentsSubmitted');  // Message display area
let submitBtn = document.querySelector('#registerButton');  // Submit button
let paragraphForm = document.querySelector('.formPara');

// only happens in the form is on the page 
if (myForm != null){
    // listen for the submit button to be pressed 
    myForm.addEventListener('submit',(e) =>{
        if (myName.value && myEmail.value) {
            e.preventDefault();
            e.stopImmediatePropagation()
            e.stopPropagation()
            const formBody = {
                name:myName.value,
                email:myEmail.value,
                message:message.value
            };
            const requestHeaders = {
                "Content-Type": "application/json"
                };
            fetch('http://localhost:3000/report', {
                method: 'POST',
                headers: requestHeaders,
                body: JSON.stringify(formBody),
                }
            ).then(response => response.json())
            .then((responsedata) => {
                console.log(responsedata);
                paragraphForm.textContent=`Hi ${responsedata.name}, your message has
                been received, we will contact you at ${responsedata.email}`;
            })
        } else {
            paragraphForm.textContent = "Error: Please fill in both fields!";
        }

    })
}
