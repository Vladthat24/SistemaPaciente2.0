select p.idpersona,p.historia_clinica,p.nombre,p.apaterno,p.amaterno,p.tipo_seguro,p.direccion,p.celular,
p.email,p.fecha_nacimiento,p.sexo,p.edad,p.fa_nombres,p.fa_apellidos,p.fa_edad,p.fa_direccion,p.fecha_actual,
p.estado_civil,p.tipo_documento,h.codigo_paciente_dni from persona p inner join h_paciente h on p.idpersona=h.idpersona where idpersona desc