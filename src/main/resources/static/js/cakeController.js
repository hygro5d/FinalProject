//to create the card field for our product listing in the selections.html

const createHTMLList = (index, name, description, imageURL) =>
`
<div class="col-lg-4">
<div class="card" style="width: 18rem;">
    <img src=${imageURL} class="card-img-top"
        alt="image">
    <div class="card-body">
        <h5 class="card-title">${name}</h5>
        <p class="card-text">${description}</p>
        <a id="${index}" href="#" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#productModal">More</a>

    </div>
</div>
</div>
`;

function displayProductDetails(item)
{
    document.querySelector("#modalName").innerText = item.name;
    document.querySelector("#modalImg").src = item.imageUrl;
    document.querySelector("#modalPrice").innerText = item.price;
    console.log(item);

}


//to create a class = cakeController
class CakeController
{
    constructor()
    {
        this._cakes = []; //set up cake as an empty array
    } // end of constructor

    //method to add new bake
    //addBake(name, description, price, bakeType,imageUrl,storeImage )
    addBake(name,description,price,bakeType,imageUrl,imageObj)
    {
           let cakeController = this;
           const formData = new FormData();
           formData.append('name', name);
           formData.append('description', description);
           formData.append('bakeType', bakeType);
           formData.append('price', price);
           formData.append('imageUrl', imageUrl);
           formData.append('imagefile',imageObj);

    //fetch('http://localhost:8080/item/add', {
    fetch('https://bakesbymates.herokuapp.com/item/add', {
                 method: 'POST',
                 body: formData
                 })
                 .then(function(response) {
                     console.log(response.status); // Will show you the status
                     if (response.ok) {
                         alert("Successfully Added Product!")
                     }
                 })
                 .catch((error) => {
                     console.error('Error:', error);
                     alert("Error adding item to Product")
                 });
        }

    displayItem()
        {
            //fetch GET HTTP method (default) the items from the database using the API
             let cakeController = this;
             cakeController._cakes = [];

             //fetch data from database using the REST API endpoint from Spring Boot
            //fetch('http://127.0.0.1:8080/item/all')
            fetch('https://bakesbymates.herokuapp.com/item/all')
                .then((resp) => resp.json())
                .then(function(data) {
                    console.log("2. receive data")
                    console.log(data);
                    data.forEach(function (item, index) {
                        const itemObj = {
                            id: item.id,
                            name: item.name,
                            description: item.description,
                            price: item.price,
                            bakeType: item.bakeType,
                            imageUrl: item.imageUrl,
                       };
                        cakeController._cakes.push(itemObj);
                  });

                  cakeController.renderProductPage();

                })
                .catch(function(error) {
                    console.log(error);
                });
        }

        renderProductPage()
        {
            let productHTMLList = [];

            for (let i=0; i<this._cakes.length; i++)
            {
                const item = this._cakes[i];            //assign the individual item to the variable

                const productHTML = createHTMLList(i, item.name, item.description, item.imageUrl);
                productHTMLList.push(productHTML);
            }

            //Join all the elements/items in my productHTMLList array into one string, and seperate by a break
            const pHTML = productHTMLList.join('\n');
            document.querySelector('#row').innerHTML = pHTML;
            console.log (pHTML);

            //addEventListener - click
            for (let i=0; i<this._cakes.length; i++)
            {
                const item = this._cakes[i];
                document.getElementById(i).addEventListener("click", function() { displayProductDetails(item);} );
            }

        }
    
}//end of cakeController

