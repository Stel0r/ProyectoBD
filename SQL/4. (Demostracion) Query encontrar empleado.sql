SELECT k_documentomensajero,n_tipodocumentomensajero,n_nombres,n_apellidos,f_fechadenacimiento,k_numerodetelefono,o_correo,n_sexo,n_seguridadsocial,n_placavehiculo,i_tipovehiculo
from (SELECT Mensajero.k_documentomensajero,Mensajero.n_tipodocumentomensajero,n_nombres,n_apellidos,f_fechadenacimiento,k_numerodetelefono,o_correo,n_sexo,n_seguridadsocial,n_placavehiculo,i_tipovehiculo, n_dia,f_horainicio,f_horafin
 FROM Mensajero,Horario where Mensajero.k_documentomensajero = Horario.k_documentomensajero and Mensajero.n_tipodocumentomensajero = Horario.n_tipodocumentomensajero and n_dia = 'TUESDAY')t;