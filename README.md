##Parte obrigatoria
Debese realizar unha aplicación que cumpra os seguintes requisitos para acadar 5 puntos:

A aplicación debe cargar os datos en JSON co seguinte formato e usando GSson do arquivo “config.json”:
~~~
{
    "directorio_orixe":"./carpeta",
    "directorio_backup":"./capeta_backup"
}
~~~
Debe copiar todos os arquivos do directorio “directorio_orixe” na carpeta “directorio_backup”. Estes arquivos de respaldo terán como nome o do arquivo orixe e engadirlle a terminación “.backup”.

Trás a copia dos arquivos deberá xerar un informe en JSON no arquivo “informe.json” cos seguintes datos do proceso de copiado:
~~~
{
    "numero_de_arquivos_copiados":20,
    "tempo_utilizado_en_segundos":2
}
~~~
NOTAS: Débese utilizar para a copia dos arquivos os FileInputStream e FileOutputStream.
##Parte opcional
Engadiranse 2 puntos máis se:

- A partir do arquivo “coronavirus.xml” mostra por pantalla o número de casos por pais do día 5 de Maio. Utiliza SAX para parsear o documento XML.
##Engadiranse 3 puntos máis se:

A partir do arquivo “coronavirus.xml” procesa a información para obter os datos por continente do número de casos e número de falecementos ao día 5 de maio. Gardao no ficheiro “coronavirus.json” co seguinte formato:
~~~
{
    "continentes":[
        {
            "nome":"Europa",
            "numero_casos": 100,
            "numero_falecementos":30
        },
        {
            "nome":"Asia",
            "numero_casos": 100,
            "numero_falecementos":30
        },
    ...
    ]
}
~~~
###Observacións
Obrigatorio usar Maven.

###Como entregar a Tarefa
Unha vez rematada sigue as seguintes indicacións para entregar a tarefa:

1. Sube a tarefa a un repositorio de nome ADREC02 a túa conta de GitHub.

2. Crea un arquivo zip co seguinte contido e enviao nesta tarefa:
    - Un arquivo txt de nome repositorio.txt co enlace ao repositorio git da aplicación.
    - Unha carpeta co código da aplicación creada.
    - O nome do arquivo zip será o seguinte: Apelido1_apelido2_nome_ADREC02.zip