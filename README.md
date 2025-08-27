# VerificadorRut

**Verificador de RUT chileno con manejo de errores**

Este proyecto implementa un verificador de RUT chileno que valida la secuencia de números y el dígito verificador (DV) según la normativa oficial. Incluye manejo de errores, detección de RUTs de testeo (ej. 11.111.111-1, 22.222.222-2) y permite al usuario ingresar RUTs hasta que se encuentre uno válido o salir del programa.

## Características

- Validación de RUTs chilenos en formato `12345678-9` o `12.345.678-9`.
- Detección y rechazo de RUTs de testeo.
- Cálculo correcto del dígito verificador.
- Mensajes claros para errores de formato y RUTs inválidos.
- Opción de salir ingresando `0`.
- Código limpio y comentado, fácil de entender.

## Contenido del repositorio

- `Rutificador.java`: Código principal del verificador de RUT.
- `README.md`: Este archivo con la descripción del proyecto.
- `Informe_RUT_Algoritmo.pdf` (o `.tex`): Informe detallado sobre el algoritmo utilizado para la validación del RUT, incluyendo explicación de multiplicadores, dígito verificador y detección de RUTs de testeo.

## Cómo usar

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/TU_USUARIO/VerificadorRut.git
