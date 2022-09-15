//Para el carrito
const templateFooter=document.getElementById("template-footer").content;
const templateCarrito=document.getElementById("template-carrito").content;
const items=document.getElementById('items');
const footer=document.getElementById('footer');
console.log("a ver",items);

//Para la Galería
cardaCambiar=['cards1','cards2','cards3','cards4','cards5']
const templateCard=document.getElementById('template-card').content
const fragment=document.createDocumentFragment()//fragment es como una memoria volatil
a=['api1.json','api2.json','api3.json','api4.json','api5.json']
for(i=0;i<=4;i++){
    b=a[i]
    const cards=document.getElementById(cardaCambiar[i]);
    const fetchData=async()=>{
        try {
                const res=await fetch(b)
                const data=await res.json()
                /* console.log(data); */
                pintarCards(data);
    
        } catch (error) {
            console.log("espera",error);
        }
    }
    fetchData()
    const pintarCards = data=>{
        data.forEach(producto=>{
            templateCard.querySelector('h5').textContent=producto.title
            templateCard.querySelector('h6').textContent=producto.precio;
            templateCard.querySelector('p').textContent=producto.descripcion;
            templateCard.querySelector('img').setAttribute("src", producto.thumbnailUrl);
            //Para asignarle un id a los botones
            templateCard.querySelector(".btn-dark").dataset.id=producto.id;
            const clone=templateCard.cloneNode(true)
            fragment.appendChild(clone)
        })   
        cards.appendChild(fragment)
    }
    //Para detectar el boton
    cards.addEventListener('click',e=>{
        addCarrito(e);
    })
}
//------------------------Para el carrito
let carrito={};
const addCarrito=e=>{
    //console.log(e.target);
    //console.log(e.target.classList.contains("btn-dark"))
    if(e.target.classList.contains("btn-dark")){
        setCarrito(e.target.parentElement)
    }
    e.stopPropagation()
}
const setCarrito=objeto=>{
    //console.log("obj",objeto);
    const producto={
        id:objeto.querySelector('.btn-dark').dataset.id,
        title:objeto.querySelector('h5').textContent,
        precio:(objeto.querySelector('h6').textContent).replace("🌿$",""),
        cantidad:1
    }
    console.log(producto);
    if(carrito.hasOwnProperty(producto.id)){
        producto.cantidad=carrito[producto.id].cantidad+1
    }
    //Para que se agregué la cantidad si el producto está repetido o no
    carrito[producto.id]={...producto}//... Sprite Operatos; crea una copia
    /* console.log(producto); */
    pintarCarrito()
}

const pintarCarrito=()=>{
    console.log("hola",carrito);
    items.innerHTML=''
    Object.values(carrito).forEach(producto=>{
        templateCarrito.querySelector('th').textContent=producto.id

        templateCarrito.querySelectorAll('td')[0].textContent=producto.title

        templateCarrito.querySelectorAll('td')[1].textContent=producto.cantidad

        templateCarrito.querySelector('.btn-info').dataset.id=producto.id

        templateCarrito.querySelector('.btn-danger').dataset.id=producto.id
        
        templateCarrito.querySelector('span').textContent=producto.cantidad*producto.precio

        const clone=templateCarrito.cloneNode(true)
        fragment.appendChild(clone)
    })
    items.appendChild(fragment)
    pintarFooter()

    localStorage.setItem('carrito',JSON.stringify(carrito))
}

const pintarFooter=()=>{
    footer.innerHTML=''
    if(Object.keys(carrito).length===0){
        footer.innerHTML='<th scope="row" colspan="5">Carrito vacío - comience a comprar!</th>'
        return
    }
    const nCantidad=Object.values(carrito).reduce((acc,{cantidad})=>acc+cantidad,0)
    const nPrecio=Object.values(carrito).reduce((acc,{cantidad,precio})=>acc+cantidad*precio,0)

    templateFooter.querySelectorAll('td')[0].textContent=nCantidad
    templateFooter.querySelector('span').textContent=nPrecio

    const clone=templateFooter.cloneNode(true)
    fragment.appendChild(clone)
    footer.appendChild(fragment)

    //Vaciar
    const btnVaciar=document.getElementById('vaciar-carrito')
    btnVaciar.addEventListener('click',()=>{
        carrito={}
        pintarCarrito()
    })

}
//Cambiar cantidades
items.addEventListener('click',e=>{
    btnAccion(e);
})
const btnAccion=e=>{
    //Acción de aumentar
    if(e.target.classList.contains('btn-info')){
        const producto=carrito[e.target.dataset.id];
        producto.cantidad++;
        carrito[e.target.dataset.id]={...producto}
        pintarCarrito();
    }
    //disminuir
    if(e.target.classList.contains('btn-danger')){
        console.log(carrito[e.target.dataset.id]);
        const producto=carrito[e.target.dataset.id];
        producto.cantidad--;
        if(producto.cantidad===0){
            delete carrito[e.target.dataset.id]
        }
        pintarCarrito();
    }
    e.stopPropagation();
}


//guardar en el local storage
document.addEventListener('DOMContentLoaded',()=>{
    if (localStorage.getItem('carrito')){
        carrito=JSON.parse(localStorage.getItem('carrito'))
        pintarCarrito()
    }
})
