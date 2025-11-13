
# Lavandería “El Limoncito”


Cada tarde, El Limoncito recibe clientes que dejan su ropa para recoger el mismo día. El módulo debe **registrar nombre y teléfono del cliente** y **crear una orden con ítems de un catálogo fijo de hoy: Camisa ($4.000, o $3.500 c/u si dejan 5 o más), Pantalón ($6.000, o $5.000 c/u desde 5) y Chaqueta ($9.000, o $7.500 c/u desde 5).** El cliente puede marcar la opción “servicio exprés”, que agrega un recargo del 10% al total. El cálculo debe hacerse así: primero subtotales por ítem usando precio por volumen cuando aplique; luego sumar para obtener el total bruto; si es exprés, agregar el 10%; al final, si el **total resultante supera $60.000, aplicar descuento del 5% (una sola vez).** **No se permiten cantidades ≤ 0 ni totales negativos.** Al confirmar la orden, no se puede editar y se debe generar un resumen claro (cliente, detalle con precio aplicado, total bruto, recargo, descuento y total final). No hay pagos ni inventario: solo tomar la orden, calcular y confirmar para agilizar la entrega.

Primer paso: Extraer requerimentos funcionales del relato.
**----------------------------------------------------------------------------------------------------------------------------------**
RF1. Registrar el cliente (Nombre, Telefono).
RF2. Crear una orden que este EN_CREACION.
RF3. Agregar Item de la orden (producto y cantidad).
RF4. Utilizar precio por cantidad si este es >= 5 item dejado.
RF5. Calcular del total de la orden (la suma de los subtotales y, si el total bruto es > $60.000 se le aplicara un descuento del 5%).
RF6. Confirmar pedido -- estado CONFIRMADO, despues de confirmado esto no se puede cambiar.
RF7. Validar de cantidades > 0, y que los totales no sean negativos.
RF8. Lista del resumen (cliente, detalle con precio aplicado, total bruto, recargo, descuento y total final).
**-----------------------------------------------------------------------------------------------------------------------------------**
Segundo paso: Reglas del negocio.
**-----------------------------------------------------------------------------------------------------------------------------------**
- Catalogo fijo de hoy: Camisa ($4.000, o $3.500 c/u si dejan 5 o más) **|** Pantalón ($6.000, o $5.000 c/u desde 5) 
    Chaqueta ($9.000, o $7.500 c/u desde 5).
- Cantidad por camisas.
- Descuento: 5% si el total bruto es > $60.000 esto solo aplica una vez.
- Aumento: Si la orden es expres, se le aplica un 10% al total bruto.
- Estados: EN_CREACION, CONFIRMADO.
- NO INVENTARIOS, NI GUI.
**-----------------------------------------------------------------------------------------------------------------------------------**
Tercer paso: Criterios de aceptacion.
CA1. Cantidad: si camisa dejadas x6, cuando calculo subtotal utilizo $3.500 c/u (no $4.000).
CA2. Aumento: Dada una orden con total bruto de $50.000 y servicio expres, cuando calcule total final sera $55.000.
CA3. Descuento: Dada una orden con total bruto de $62.000, cuando calcule total final sera $58.900.
CA4. Bloqueo: Dada orden CONFIRMADO, cuando intente agragar item, se rechaza la peticion.
CA5. Validacion: Dado cantidad 0 o negativa, cuando agrego item, entonces se rechaza la accion.
CA6. Resumen: Dada una orde valida, cuando se pida el resumen, entonces se muestra los items con 
     cliente, detalle con precio aplicado, total bruto, recargo, descuento y total final.
**----------------------------------------------------------------------------------------------------------------------------------**







