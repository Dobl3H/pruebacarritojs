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
    
    //Vaciar despues de que paga
    const btnFinalizarCompra=document.getElementById('btnabrir')
    btnFinalizarCompra.addEventListener('click',()=>{
        carrito={}
        pintarCarrito()
    })

}


//guardar en el local storage
document.addEventListener('DOMContentLoaded',()=>{
    if (localStorage.getItem('carrito')){
        carrito=JSON.parse(localStorage.getItem('carrito'))
        pintarCarrito()
    }
})


//-------------------Para enlazar con el backend---------------------------
const boton = document.getElementById('btnabrir');

//para que solo cuando oprima el botón se genere todo
boton.addEventListener('click',e=>{
    e.preventDefault();
    //como es más de un registro:
    idsNuevosElementos=[]
    for (const property in carrito) {
        subobj=carrito[property]
        jason=JSON.stringify({
            precio_por_unidades: subobj.precio,
            unidades: subobj.cantidad
            /* idProducto: subobj.id */
        })
        console.log("soy el json ",jason);
        localStorage.setItem('id_producto',subobj.id)
        
    
        fetch('https://akan-un-lugar-para-el-arte-1.herokuapp.com/detalledepedido', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                precio_por_unidades: subobj.precio,
                unidades: subobj.cantidad,
                id_cliente: {"id_cliente":
                localStorage.getItem('id_cliente')
            }
            }),
        })

            .then(response => response.json())
            .then(data => {
                console.log('Success:', data);
                id_producto=subobj.id
                //"Para que se rellene aquí la otra tabla"
                fetch('https://akan-un-lugar-para-el-arte-1.herokuapp.com/productosypedidos', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        id_producto: {
                            "id_producto":1
                        },
                        id_pedido: {
                            "id_pedido":data.id_pedido
                        }
                    }),
                })
                .then(response => response.json())
                .then(dataProductosYpedidos => {
                    console.log('Success:', dataProductosYpedidos);
                })
                .catch((error) => {
                    console.error('Error:', error);
                });
            

                //Para pago
                fetch('https://akan-un-lugar-para-el-arte-1.herokuapp.com/metodopago',{
                method: 'POST',
                headers:{
                    'Content-Type': 'application/json'
                },
                    body: JSON.stringify({
                    numTarjeta:localStorage.getItem('numTarjeta'),
                    nombreUsuarioTarjeta:localStorage.getItem('nombreTarjeta'),
                    mesTarjeta:localStorage.getItem('mes'), 
                    yearTarjeta:localStorage.getItem('year'),
                    ccv:localStorage.getItem('ccv'),
                    id_pedido:{
                        id_pedido:data.id_pedido
                    }
                })
            })


            })
            .catch((error) => {
                console.error('Error:', error);
            });
    }
});
//console.log("arreglodebe",localStorage.getItem('id'));
//La tabla de productos y pedidos se debe rellenar aquí

