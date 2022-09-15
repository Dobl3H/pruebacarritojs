
 function contraseOlv(){
    let correoElec2=document.getElementById('correo2').value;
    let contraseña1=document.getElementById('contra-1').value;
    let contraseña2=document.getElementById('contra-2').value;
    const expresionCorreo = /\w+@\w+\.+[a-z]/;
    const expresionPass = /^.{4,12}$/;

    /* if (correoElec2==""){
        //alert("Ingrese correo Electronico");
        document.getElementById("correo2").focus();
        return false;
    }else
        if (contraseña1==""){
            //alert("Ingrese Contraseña");
            document.getElementById("contra-1").focus();
            return false
    }else if (contraseña2===""){
            //alert("Ingrese Contraseña2");
            document.getElementById("contra-2").focus();
            return false

    } */ if (!expresionCorreo.test(correoElec2)){
        alert('El correo es invalido')
        document.getElementById("correo2").focus();
        return false
        
    }
     if (!expresionPass.test(contraseña1)){
        alert('la contraseña es Invalida'+'\nLa contraseña debe tener de 4 a 12 caracteres')
        document.getElementById("contra-1").focus();
        return false

    } if (!expresionPass.test(contraseña2)){
        alert('la contraseña es Invalida'+'\nLa contraseña debe tener de 4 a 12 caracteres')
        document.getElementById("contra-2").focus();
        return false
    
    } else {
        console.log(correoElec2 +" "+contraseña1+" "+contraseña2);
        document.getElementById("correo2").value="";
        document.getElementById("contra-1").value="";
        document.getElementById("contra-2").value="";
        }
        let recupContraseña = {correoElec2, contraseña1, contraseña2}
        let recupContraseñaJson = JSON.stringify(recupContraseña );
        console.log(recupContraseña );
        console.log(recupContraseñaJson);
         
    }
 