select idpersona,acceso_idacceso,usuario_reg,historia_clinica,nombre,apellidos,
tipo_seguro,direccion,celular,email,fecha_nac,lugar_nac,lugar_proc,sexo,edad,fecha_reg,
estado_civil,tipo_doc,num_doc,grado_instruc,ocupacion,religion,fa_nombres,fa_apellidos,fa_edad,
fa_direccion from persona where num_documento like '%'+buscar+'%' order by historia_clinica desc 


t.idtrabajadorp.nombre,p.apaterno,p.amaterno,p.profesion,p.cargo_institucion,p.modalidad_contrato,p.tipo_documento,
t.num_documento,t.celular,t.email,t.fecha_registro from persona_trabajador p inner join trabajador t
on p.idptrabajador=t.idptrabajador where num_documento like '%'+ buscar + '%' order by idptrabajador desc


//seleccionado datos de la base de datos para mostrar en la view del aplicativo
select idusuarios,nombre,apellidos,condicionlab,area from usuarios where nombre like '%' + buscar +'%' order by idusuarios desc 

//insertnado datos a la tabla
insert into usuarios (nombre,apellidos,condicionlab,area) value (?,?,?,?)

//editando la informacion de la tabla
update usuarios set nombre=?,apellidos=?,condicionlab=?,area=? where idusuarios=?

//seleccionando datos de la basa de datos para mostrar usuarios login
select idlogin,idusuarios,(select nombre from usuarios where idusuarios=idlogin) as Nombretrab,(select apellidos from usuarios where idusuarios=idlogin)as ApellidoTrab,user,pass where like '%'+ buscar+'%' order by idlogin desc


//error en la seleccion de la tablas 
        sql = "select r.idrecepcion,r.idtrabajador,"
				+ "(select nombre from persona_trabajador where idptrabajador=idptrabajador limit 1)as nombre_trab,"
                + "(select apaterno from persona_trabajador where idptrabajador=idptrabajador )as apaterno_trab,"
                + "(select amaterno from persona_trabajador where idptrabajador=idptrabajador )as amaterno_trab,"
                + " r.correlativo,r.referencia,r.asunto,r.fecha,emisor,r.recepcionado,r.observaciones "
                + " from recepcion r inner join  h where correlativo like '%" + buscar + "%' or asunto like '%" + buscar + "%' or emisor like '%"
                + buscar + "%' order by idrecepcion desc";
				
				
DECLARE @buscar varchar(50);
SET @buscar ='001';

select r.idrecepcion,r.idtrabajador,
(select nombre from persona_trabajador where idptrabajador=idptrabajador )as nombre_trab,
(select apaterno from persona_trabajador where idptrabajador=idptrabajador )as apaterno_trab,
(select amaterno from persona_trabajador where idptrabajador=idptrabajador )as amaterno_trab,
r.correlativo,r.referencia,r.asunto,r.fecha,r.emisor,r.recepcionado,r.observaciones 
from recepcion r inner join persona_trabajador h on r.idptrabajador=h.idpersona_trabajador where correlativo '%' @buscar'%'order by idrecepcion desc			 
				 
				 CORRELATIVO=001
				 ASUNTO=asdasd
				 EMISOR=asda
				 
				 select idrecepcion,idtrabajador,(select nombre from persona_trabajador where idptrabajador=idptrabajador)as nombre_trab, (select apaterno from persona_trabajador where idptrabajador=idptrabajador)as apaterno_trab, (select amaterno from persona_trabajador where idptrabajador=idptrabajador)as amaterno_trab, correlativo,referencia,asunto,fecha,emisor,recepcionado,observaciones from recepcion where asunto
				 order by idrecepcion desc
				 
DECLARE @buscar int DEFAULT 1;
set @buscar

select idrecepcion,idtrabajador,(select nombre from persona_trabajador where idptrabajador=idptrabajador)as nombre_trab,
correlativo,referencia,asunto,fecha,emisor,recepcionado,observaciones 
from recepcion where correlativo like % @buscar % order by idrecepcion desc




//consulta de reporte recepcion documento
select idrecepcion,idtrabajador,
(select nombre from persona_trabajador where idptrabajador=idtrabajador)as nombre_trab,
(select apaterno from persona_trabajador where idptrabajador=idtrabajador)as apaterno_trab,
(select amaterno from persona_trabajador where idptrabajador=idtrabajador)as amaterno_trab,
correlativo,referencia,asunto,fecha,emisor,recepcionado,observaciones 
from recepcion where fecha between $P{fecha_inicial} and $P{fecha_final};
//declare es con procedimiento
DECLARE @fechainicio varchar(30);
DECLARE @fechafinal varchar(30);
//sin procedimiento declare
set @fechainicio = '12/12/2017';
set @fechafinal = '25/9/2018';


//consulta para buscar una persona con el dni


set @buscar='81572257';

select idpersona,acceso_idacceso,usuario_reg,historia_clinica,nombre,apellidos,
tipo_seguro,direccion,celular,email,fecha_nac,lugar_nac,lugar_proc,sexo,edad,fecha_reg,
estado_civil,tipo_doc,num_doc,grado_instruc,ocupacion,religion,fa_nombres,fa_apellidos,fa_edad,
fa_direccion from persona where num_doc like @buscar order by historia_clinica desc 




