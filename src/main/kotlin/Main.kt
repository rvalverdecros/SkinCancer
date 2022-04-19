import java.io.File
import java.lang.Exception


fun main(args: Array<String>) {
    var entrada: String
    var salida: String
    entrada = args[0]
    salida = args[1]

    if (args.size == 0) {
        println("tomare entrada y salida estandar")
    } else {
        if ("-o".equals(args[0])) {
            salida = args[1]
        } else if ("-i".equals(args[0])) {
            entrada = args[1]
        }
        if ("-o".equals(args[2])) {
            salida = args[3]
        } else if ("-i".equals(args[2])) {
            entrada = args[3]
        }
        val input = Archivo(entrada)
        val intarray = input.leernumeros()
        //val output = SacarArchivo(salida)
    val numArray = intArrayOf(50,70,80,40,20,70,50,30,40,60,50,70,80,40,20,70,50,30,40,60,50,70,80,40)
    val stdev = calculateSD(numArray)
    val media = promedio(numArray)

    if (40<=media||media<=80||stdev>=10){
        println("Cancer de Piel")
    }else if (80<media||media<=230){
        println("Lunar Cutaneo Benigno")
    }else if (stdev<10){
        println("Lunar Cutaneo Benigno")
    }else if (media<40){
        println("Recalibra el Microscopio")
    }else if (media>230){
        println("Recalibra el Microscopio")
    }

}
}
class Archivo(path: String){

    var input = path
    fun leernumeros() {
        val numArray = intArrayOf(50,70,80,40,20,70,50,30,40,60,50,70,80,40,20,70,50,30,40,60,50,70,80,40)
        val listaNumeros = mutableListOf<String>()
        File(input).forEachLine { listaNumeros.add(it) }
        val listaArchivoListas = mutableListOf<List<String>>()
        listaNumeros.forEach { listaArchivoListas.add(it.trim().split(" ")) }
        println(File(input))

    }
}


fun promedio(numArray: IntArray): Double{
    var sum = 0.0
    var med = 0.0
    for (num in numArray){
        sum +=num
    }
    med = sum/(numArray.size-1)
    return med
}

fun calculateSD(numArray: IntArray): Double {
    var sum = 0.0
    var standardDeviation = 0.0

    for (num in numArray) {
        sum += num
    }

    val mean = sum / 10

    for (num in numArray) {
        standardDeviation += Math.pow(num - mean, 2.0)
    }

    return Math.sqrt(standardDeviation / 10)
}