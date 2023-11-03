# Bootcamp-Spring-Biblioteca

La Biblioteca Bootcamp-Spring-Biblioteca es una aplicación de gestión de bibliotecas que te permite administrar libros, préstamos y usuarios de manera eficiente.

## Características

- Registro de libros
- Registro de usuarios
- Gestión de préstamos
- Devoluciones de libros
- Búsqueda de libros
- Historial de préstamos

## Cosas que fallan

La Biblioteca Bootcamp-Spring-Biblioteca es una herramienta útil, pero actualmente tiene algunas limitaciones y áreas en las que falla:

1. **Control de Multas para Añadir Libro en el Lector:** Actualmente, no existe una funcionalidad completa para el control de multas al agregar un libro atrasado o dañado en el perfil del lector. Esto significa que los usuarios pueden devolver los libros con retraso sin que se les aplique una multa adecuada.
2. **Validar Estado de las copias en lista de prestamos:** Actualmente, no se realiza una validación adecuada del estado de la copias prestadas al permitir que un usuario tome prestados la misma copia y modifica ambos prestamos, creando discordancias y fallos en otros metodos como añadir prestamos y su control de copias.
3. **Validar Multa para No Prestar Cuando Está Multado:** No existe una función que impida prestar libros a un usuario que tiene multas pendientes. Esto puede llevar a problemas de incumplimiento de pago de multas.
4. **Testing Multas:** Falta una suite de pruebas sólida para la funcionalidad de multas. Las pruebas son importantes para garantizar que las multas se calculen y apliquen correctamente.

## Cosas que faltan por hacer

Además de abordar las limitaciones actuales, hay algunas tareas pendientes que mejorarían la Biblioteca Bootcamp-Spring-Biblioteca:

1. **Funcionalidad de Morosos:** Implementar una funcionalidad que marque a los usuarios como morosos cuando tengan multas pendientes y les limite la capacidad de realizar más préstamos.

2. **Idioma (Internacionalización):** Agregar soporte para múltiples idiomas (internacionalización) para hacer que la biblioteca sea más accesible para un público global.

3. **Arreglar Warnings de Despliegue:** Abordar y solucionar los mensajes de advertencia o errores en el proceso de despliegue de la aplicación.

## Contribuir

Si te gustaría contribuir al desarrollo de la Biblioteca Bootcamp-Spring-Biblioteca, por favor consulta nuestra [Guía de Contribución](CONTRIBUTING.md) para obtener más información sobre cómo empezar. Apreciamos todas las contribuciones para hacer que la aplicación sea más sólida y confiable.

## Tablero de Trello

Puedes seguir nuestro progreso y conocer las tareas pendientes en nuestro tablero de Trello: [Biblioteca Bootcamp-Spring-Biblioteca en Trello](https://trello.com/invite/b/ptSax2rG/ATTIf2b5913509283e55dae7216f41c9284c2615324C/bibliotecaspring).

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo [LICENSE](LICENSE) para más detalles.

## Contacto

Si tienes alguna pregunta o sugerencia, por favor contáctanos en [pablo.diaz-rubio@capgemini.com](mailto:pablo.diaz-rubio@capgemini.com) o crea un nuevo problema en este repositorio.

¡Gracias por tu interés en la Biblioteca Bootcamp-Spring-Biblioteca!

## Colaboradores
 - Pablo Díaz Rubio
 - Patricia Fernández Sánchez
 - David Santos Miguélez
