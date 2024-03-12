/* LAN0 - 2024-03-12 - Librerias necesarias

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;

*/

/* LAN0 - 2024-03-12 - Funcion para devolver las respuestas de consultas SQL de un servlet en html renderizable desde navegador */

public static String getMyTableStriped(String title, ResultSet resultSet) {
        
        StringBuilder resultado = new StringBuilder();

        /* TODO output your page here. You may use following sample code. */
        resultado.append("<html>" + "\n" );
        resultado.append("<head>" + "\n" );
        resultado.append("  <meta charset=\"UTF-8\">" + "\n" );
        resultado.append("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" + "\n" );
        resultado.append("  <title>" + title + "</title>" + "\n" );
        resultado.append("  <!-- Bootstrap CSS -->" + "\n" );
        resultado.append("  <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css\" rel=\"stylesheet\">" + "\n" );
        resultado.append("  <!-- DataTables CSS -->" + "\n" );
        resultado.append("  <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/1.11.3/css/dataTables.bootstrap5.min.css\">" + "\n" );
        resultado.append("  <!-- Buttons DataTables CSS -->" + "\n" );
        resultado.append("  <link rel=\"stylesheet\" type=\"text/css\" href=\"https://cdn.datatables.net/buttons/2.0.0/css/buttons.dataTables.min.css\">" + "\n" );
        resultado.append("  <!-- jQuery -->" + "\n" );
        resultado.append("  <script src=\"https://code.jquery.com/jquery-3.5.1.js\"></script>" + "\n" );
        resultado.append("  <!-- DataTables JS -->" + "\n" );
        resultado.append("  <script src=\"https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js\"></script>" + "\n" );
        resultado.append("  <!-- Bootstrap 5 DataTables integration JS -->" + "\n" );
        resultado.append("  <script src=\"https://cdn.datatables.net/1.11.3/js/dataTables.bootstrap5.min.js\"></script>" + "\n" );
        resultado.append("  <!-- Buttons DataTables JS -->" + "\n" );
        resultado.append("  <script src=\"https://cdn.datatables.net/buttons/2.0.0/js/dataTables.buttons.min.js\"></script>" + "\n" );
        resultado.append("  <!-- JSZip (necesario para la exportación a Excel) -->" + "\n" );
        resultado.append("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js\"></script>" + "\n" );
        resultado.append("  <!-- PDFMake (necesario para la exportación a PDF, opcional si solo quieres Excel y CSV) -->" + "\n" );
        resultado.append("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js\"></script>" + "\n" );
        resultado.append("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js\"></script>" + "\n" );
        resultado.append("  <!-- Buttons HTML5 (necesario para la funcionalidad de botones de exportación) -->" + "\n" );
        resultado.append("  <script src=\"https://cdn.datatables.net/buttons/2.0.0/js/buttons.html5.min.js\"></script>" + "\n" );
        // Estilos CSS
        resultado.append("<style>" + "\n" );
        
        resultado.append("   .container-fluid {" + "\n" );
        resultado.append("       background-color: white;" + "\n" );
        resultado.append("       min-height: 200px;" + "\n" );
        resultado.append("       width: 100%;" + "\n" );
        resultado.append("   }" + "\n" );
        
        resultado.append("   table {" + "\n" );
        resultado.append("    width: 100%;" + "\n" );
        resultado.append("    border-collapse: collapse;" + "\n" );
        resultado.append("   }" + "\n" );
        
        resultado.append("   h1 {" + "\n" );
        resultado.append("    text-align: center;" + "\n" );
        resultado.append("    padding-top: 5%;" + "\n" );
        resultado.append("   }" + "\n" );
        
        resultado.append("  .dt-button {" + "\n" );
        resultado.append("      background-color: #198754 !important; /* Color verde de Bootstrap para botones success */" + "\n" );
        resultado.append("      color: white !important;" + "\n" );
        resultado.append("      padding: 5px 10px;" + "\n" );
        resultado.append("      margin-right: 5px;" + "\n" );
        resultado.append("      border: none !important;" + "\n" );
        resultado.append("      border-radius: 0.25rem;" + "\n" );
        resultado.append("      text-align: center;" + "\n" );
        resultado.append("      text-decoration: none;" + "\n" );
        resultado.append("      display: inline-block;" + "\n" );
        resultado.append("      font-size: 16px;" + "\n" );
        resultado.append("      transition-duration: 0.4s;" + "\n" );
        resultado.append("  }" + "\n" );

        resultado.append("  .dt-button:hover {" + "\n" );
        resultado.append("      background-color: #145d32 !important; /* Color verde oscuro para el hover */" + "\n" );
        resultado.append("          color: white;" + "\n" );
        resultado.append("  }" + "\n" );
        
          /* Estilos personalizados para la paginación */
        resultado.append("  .dataTables_wrapper .dataTables_paginate .paginate_button {" + "\n" );
        resultado.append("      background-color: #198754 !important; /* Color verde para botones de paginación */" + "\n" );
        resultado.append("      border: 1px solid #198754; /* Borde del botón */" + "\n" );
        resultado.append("      color: white !important; /* Color del texto */" + "\n" );
        resultado.append("      padding: 5px 10px; /* Espaciado interno */" + "\n" );
        resultado.append("      margin: 0 2px; /* Margen entre botones */" + "\n" );
        resultado.append("      border-radius: 0.25rem; /* Bordes redondeados */" + "\n" );
        resultado.append("  }" + "\n" );

        resultado.append("  .dataTables_wrapper .dataTables_paginate .paginate_button:hover {" + "\n" );
        resultado.append("      background-color: #145d32 !important; /* Color verde oscuro al pasar el mouse */" + "\n" );
        resultado.append("      border-color: #145d32;" + "\n" );
        resultado.append("  }" + "\n" );

        resultado.append("  .dataTables_wrapper .dataTables_paginate .paginate_button.current," + "\n" );
        resultado.append("  .dataTables_wrapper .dataTables_paginate .paginate_button.current:hover {" + "\n" );
        resultado.append("      background-color: #145d32 !important; /* Color del botón actual */" + "\n" );
        resultado.append("      color: white !important;" + "\n" );
        resultado.append("  }" + "\n" );

        resultado.append("  /* Para mantener el estilo al deshabilitar botones (anterior/siguiente) cuando no están disponibles */" + "\n" );
        resultado.append("  .dataTables_wrapper .dataTables_paginate .paginate_button.disabled," + "\n" );
        resultado.append("  .dataTables_wrapper .dataTables_paginate .paginate_button.disabled:hover," + "\n" );
        resultado.append("  .dataTables_wrapper .dataTables_paginate .paginate_button.disabled:active {" + "\n" );
        resultado.append("      background-color: #e9ecef !important;" + "\n" );
        resultado.append("      border-color: #dee2e6;" + "\n" );
        resultado.append("      color: #6c757d !important;" + "\n" );
        resultado.append("  }" + "\n" );
        
        resultado.append("/* Cambiar el color de fondo y texto de .page-link para los enlaces de paginación */" + "\n" );
        resultado.append("  .dataTables_wrapper .dataTables_paginate .paginate_button .page-link {" + "\n" );
        resultado.append("      color: white !important; /* Cambia el color del texto a blanco */" + "\n" );
        resultado.append("      background-color: #198754 !important; /* Cambia el color de fondo a verde */" + "\n" );
        resultado.append("      border-color: #198754 !important; /* Cambia el color del borde a verde */" + "\n" );
        resultado.append("  }" + "\n" );

        resultado.append("/* Estilo para el enlace de la página activa */" + "\n" );
        resultado.append("  .dataTables_wrapper .dataTables_paginate .paginate_button.current .page-link," + "\n" );
        resultado.append("  .dataTables_wrapper .dataTables_paginate .paginate_button.current:hover .page-link {" + "\n" );
        resultado.append("      color: white !important; /* Asegura que el texto sea blanco */" + "\n" );
        resultado.append("      background-color: #145d32 !important; /* Un verde más oscuro para el fondo */" + "\n" );
        resultado.append("      border-color: #145d32 !important; /* Un verde más oscuro para el borde */" + "\n" );
        resultado.append("  }" + "\n" );

        resultado.append("/* Ajustar el hover de los enlaces que no están activos para que coincidan */" + "\n" );
        resultado.append("  .dataTables_wrapper .dataTables_paginate .paginate_button:not(.current):hover .page-link {" + "\n" );
        resultado.append("      background-color: #145d32 !important; /* Verde más oscuro en hover */" + "\n" );
        resultado.append("      border-color: #145d32 !important; /* Borde verde más oscuro en hover */" + "\n" );
        resultado.append("  }" + "\n" );
               
        resultado.append("</style>" + "\n" );      
        // Fin Estilos CSS         
        resultado.append("</head>" + "\n" );
        resultado.append("  <body>" + "\n" );
        resultado.append("      <h1>" + title + "</h1>" + "\n" );
        resultado.append("      <div class=\"container-fluid\" style=\"padding: 5%;\">" + "\n" );
        resultado.append("      <table id=\"myTabla\" class=\"table table-success table-striped\">" + "\n" );        
        
        try {
            ResultSetMetaData myMetaData = resultSet.getMetaData();
            int colNumber = myMetaData.getColumnCount();
            
            // Creamos la cabecera
            resultado.append("      <thead>" + "\n" );
            resultado.append("          <tr>" + "\n" );            
            for (int nConta = 1; nConta < colNumber + 1; nConta++) {                
                resultado.append("          <th scope=\"col\">" + myMetaData.getColumnName(nConta) + "</th>" + "\n" );                
            }
            resultado.append("          </tr>" + "\n" );
            resultado.append("      </thead>" + "\n" );            
            // Final creacion cabecera
            resultado.append("      <tbody>" + "\n" ); 
            int nRow = 1 ;
            while (resultSet.next()) {
                Object[] rowData = new Object[colNumber];
                resultado.append("      <tr>" + "\n" );
                // resultado.append("         <th scope=\"row\">" + ( nRow ) + "</th>");
                for (int nConta = 0; nConta < rowData.length; nConta++) {
                    resultado.append("      <td>" + resultSet.getObject(nConta+1) + "</td>" + "\n" );
                    // resultSet.getObject(nConta+1);
                }
                resultado.append("      </tr>" + "\n" ); 
                nRow++;
            }
            resultado.append("      </tbody>" + "\n" ); 
            resultado.append("</table>" + "\n" );
            resultado.append("</div>" + "\n" );
            
            resultado.append("  <script>");
            resultado.append("      $(document).ready(function() {" + "\n" );
            resultado.append("        $('#myTabla').DataTable({" + "\n" );
            resultado.append("        dom: 'Bfrtip', // Este parámetro define la posición de los elementos (Botones, filtro de búsqueda, información, paginación)" + "\n" );
            resultado.append("       buttons: [" + "\n" );
            resultado.append("      {" + "\n" );
            resultado.append("          extend: 'excelHtml5'," + "\n" );
            resultado.append("          text: 'Exportar a Excel'," + "\n" );
            resultado.append("          titleAttr: 'Excel'" + "\n" );
            resultado.append("      }," + "\n" );
            resultado.append("      {" + "\n" );
            resultado.append("          extend: 'csvHtml5'," + "\n" );
            resultado.append("          text: 'Exportar a CSV'," + "\n" );
            resultado.append("          titleAttr: 'CSV'" + "\n" );
            resultado.append("      }" + "\n" );
            resultado.append("      ]" + "\n" );
            resultado.append("      });" + "\n" );
            resultado.append("      });" + "\n" );
            resultado.append("  </script>" + "\n" );
            
            resultado.append("</body>" + "\n" );
            resultado.append("</html>" + "\n" );   
            
        } catch (SQLException ex) {
            log.error(ex.getMessage());
        }

        return resultado.toString();
    }
