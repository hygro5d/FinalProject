//to initialise a new task

const cakesControl = new CakeController();
let storeImage = ""

const form = document.getElementById("newCakeForm");

let numberChecker = /\d/; 
//prevent the link from proceeding before validation
newCakeForm.addEventListener('submit', (event) => 
{
    // Prevent default action
    event.preventDefault();

    //select input
    const newCakeNameInput = document.getElementById("newCakeNameInput");
    const newCakePriceInput = document.getElementById("newCakePriceInput");
    const newCakeDescriptionInput = document.getElementById("newCakeDescriptionInput");
    const productType = document.getElementById("productType");
    const cakeImg = document.querySelector("#upload-image");

    //validation code
    const nameValue = newCakeNameInput.value.trim();
    const descriptionValue = newCakeDescriptionInput.value.trim();

    if (nameValue === ""){//test if name is empty such as spacebar
        alert ("Name cannot be blank");
    }
    else if (numberChecker.test(nameValue)==true){//test for numeral in name field
        alert ("Name cannot have numeral");
    }
    else if (descriptionValue === ""){//test for description blank
        alert("Description cannot be blank");
    }

    else{
    // Get the values of the inputs
    const name = newCakeNameInput.value;
    const description = newCakeDescriptionInput.value;
    const price = newCakePriceInput.value;
    const bakeType = productType.options[productType.selectedIndex].text;
    const imageUrl = cakeImg.value.replace("C:\\fakepath\\", "");

    // Clear the form
    newCakeNameInput.value = '';
    newCakeDescriptionInput.value = '';
    newCakePriceInput.value = '';
    productType.value = '';
    cakeImg.value = '';

    // Add the task to the task manager
    cakesControl.addBake(name, description, price, bakeType,imageUrl,storeImage );
    }

});
const input = document.querySelector('#upload-image');

// add event listener
input.addEventListener('change', () => {

    storeImage = input.files[0];

});








