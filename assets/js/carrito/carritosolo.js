const templateFooter=document.getElementById("template-footer").content;
const templateCarrito=document.getElementById("template-carrito").content;
const items=document.getElementById('items');
const footer=document.getElementById('footer');
const fragment=document.createDocumentFragment();

document.addEventListener('DOMContentLoaded',()=>{
    if (localStorage.getItem('carrito')){
        carrito=JSON.parse(localStorage.getItem('carrito'))
        console.log("exp",carrito);
    }
})
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
