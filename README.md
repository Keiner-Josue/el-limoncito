# Lavandería “El Limoncito”


Cada tarde, El Limoncito recibe clientes que dejan su ropa para recoger el mismo día. El módulo debe **registrar nombre y teléfono del cliente** y 
**crear una orden con ítems de un catálogo fijo de hoy: Camisa ($4.000, o $3.500 c/u si dejan 5 o más), Pantalón ($6.000, o $5.000 c/u desde 5) y Chaqueta ($9.000, o $7.500 c/u desde 5).** 
El cliente puede marcar la opción “servicio exprés”, que agrega un recargo del 10% al total. El cálculo debe hacerse así: primero subtotales por ítem usando precio por volumen cuando aplique; 
luego sumar para obtener el total bruto; si es exprés, agregar el 10%; al final, si el **total resultante supera $60.000, aplicar descuento del 5% (una sola vez).** **No se permiten cantidades ≤ 0 ni totales negativos.**
Al confirmar la orden, no se puede editar y se debe generar un resumen claro (cliente, detalle con precio aplicado, total bruto, recargo, descuento y total final). 
No hay pagos ni inventario: solo tomar la orden, calcular y confirmar para agilizar la entrega.

# Primer paso: Extraer requerimentos funcionales del relato.

RF1. El sistema debe permitir registrar el cliente (Nombre, Telefono).
RF2. El sistema debe permitir Crear una orden que este EN_CREACION.
RF3. El sistema debe permitir agregar Item de la orden (producto y cantidad).
RF4. El sistema debe permitir utilizar precio por cantidad si este es >= 5 item dejado.
RF5. El sistema debe permitir calcular del total de la orden (la suma de los subtotales y, si el total bruto es > $60.000 se le aplicara un descuento del 5%).
RF6. EL sistema debe permitir confirmar pedido -- estado CONFIRMADO, despues de confirmado esto no se puede cambiar.
RF7. El sistema debe permitir validar de cantidades > 0, y que los totales no sean negativos.
RF8. El sistema debe mostrar un resumen detallado (cliente, detalle con precio aplicado, total bruto, recargo, descuento y total final).

# Segundo paso: Reglas del negocio.

- Catalogo fijo de hoy: Camisa ($4.000, o $3.500 c/u si dejan 5 o más) **|** Pantalón ($6.000, o $5.000 c/u desde 5) 
    Chaqueta ($9.000, o $7.500 c/u desde 5).
- Cantidad por camisas.
- Descuento: 5% si el total bruto es > $60.000 esto solo aplica una vez.
- Aumento: Si la orden es expres, se le aplica un 10% al total bruto.
- Estados: EN_CREACION, CONFIRMADO.
- NO INVENTARIOS, NI GUI.

# Tercer paso: Criterios de aceptacion.

CA1. Dado que existe un cliente registrado cuando el usuario crea una orden entonces la orden debe quedar asociada al cliente 
CA2. Dado que existe una orden pendiente cuando se agrega un item con una cantidad valida entonces el sistema debe registrarse el servicio, la cantidad, el precio unitario y su subtotal 
CA3. Dado la orden esta pendiente cuando el usuario activa el servicio expres entonces la orden debe marcarse como expres y debe sumar el recargo corespondiente al total final.
CA4. Dado una orden con uno o varios servicios cuando el sistema calcula los costos entonces debe generar totalbruto, descuento aplicado, recargo expres, total final.
CA5. Dado que la orden esta pendiente cuando el usuario confirme la orden entonces el estado debe cambiar a confirmada y no debe permitir mas modificaciones 
CA6. Dado una orden valida cuando el usuario solicite el resumen entonces el sistema debe mostrar un texto con cliente, servicios, costos y total final

# Cuarto paso: Diseño uml 


![alt text](/src/assets/image.png)


# Quinto paso: Arquitectura modular 
![alt text](/src/assets/image-1.png)

# Sexto paso: pruebas por criterio CON CADA IMAGEN 

CA1
![alt text](/src/assets/image-2.png)

CA2
![alt text](/src/assets/image-3.png)
CA3
![alt text](/src/assets/image-4.png)
![alt text](/src/assets/image-5.png)

CA4 
![alt text](/src/assets/image-6.png)

CA5 
![alt text](/src/assets/image-7.png)

CA6
![alt text](/src/assets/image-8.png)