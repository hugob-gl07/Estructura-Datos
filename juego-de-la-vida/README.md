# Juego de la Vida de Conway (Scala)

Proyecto sbt para IntelliJ IDEA (con el plugin de Scala).

## Estructura

```
juego-de-la-vida/
├── build.sbt
├── project/build.properties
├── src/main/scala/conway/
│   ├── Main.scala          # punto de entrada
│   ├── modelo/             # Celula, Tablero, ...
│   ├── logica/             # reglas y generaciones
│   └── io/                 # lectura/escritura de archivos
├── src/test/scala/conway/  # pruebas unitarias (ScalaTest)
├── pruebas/                # archivos de prueba del trabajo
│   ├── entradas/
│   └── salidas_esperadas/
└── docs/                   # enunciado e informe
```

## Uso

En IntelliJ: *File > Open* sobre esta carpeta (`build.sbt`) e importar como proyecto sbt.

Desde terminal: `sbt run` y `sbt test`.
