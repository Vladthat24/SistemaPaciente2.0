select a.idacceso,t.idtrabajador,
(select nombre from trabajador where t.idtrabajador=idtrabajador),
(select apellidos from trabajador where t.idtrabajador=idtrabajador),
a.acceso,a.login,a.password,a.estado,a.fecha_reg from acceso a inner join trabajador t on a.acceso=t.idtrabajador