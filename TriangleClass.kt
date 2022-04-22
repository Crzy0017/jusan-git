import java.util.*
import kotlin.math.*

internal class Point {
    var x = 0.0    // x-value
    var y = 0.0   // y-value

    override fun toString(): String {
        return "($x;$y)"
    }

    fun printPoint() {
        print(this.toString())
    }

    fun setPoint(a: Double, b: Double) {
        x = a
        y = b
    }

    constructor() {
        println("Enter x-coordinate: ")
        val sc1 = Scanner(System.`in`)
        x = sc1.nextInt().toDouble()

        println("Enter y-coordinate:")
        val sc2 = Scanner(System.`in`)
        y = sc2.nextInt().toDouble()
    }

    constructor(a: Double, b: Double) {
        x = a
        y = b
    }

    fun collinear(p1: Point?, p2: Point?): Boolean {
        val slope1 = (p1!!.y - y)/(p1.x - x)
        val slope2 = (p2!!.y - y)/(p2.x - x)
        return if (slope1 == slope2) {
            println("Points are Collinear")
            true
        } else {
            println("Points are not collinear")
            false
        }
    }
}

internal class Triangle {
    var a: Point? = null
        private set
    var b: Point? = null
        private set
    var c: Point? = null
        private set

    constructor() {
        val a = Point()
        val b = Point()
        val c = Point()
        if (!a.collinear(b, c)) {
            this.a = Point(a.x, a.y)
            this.b = Point(b.x, b.y)
            this.c = Point(c.x, c.y)
        } else {
            println("Points are collinear")
            this.a = Point(-1.0, 0.0)
            this.b = Point(0.0, 1.0)
            this.c = Point(1.0, 1.0)
        }
    }

    constructor(ax: Double, ay: Double, bx: Double, by: Double, cx: Double, cy: Double) {
        val a = Point(ax, ay)
        val b = Point(bx, by)
        val c = Point(cx, cy)
        if (!a.collinear(b, c)) {
            this.a = Point(ax, ay)
            this.b = Point(bx, by)
            this.c = Point(cx, cy)
        } else {
            println("Points are collinear")
            this.a = Point(-1.0, 0.0)
            this.b = Point(0.0, 1.0)
            this.c = Point(1.0, 1.0)
        }
    }

    override fun toString(): String {
        return "Triangle with coordinates: A=" + a.toString() + "; B=" + b.toString() + "; C=" + c.toString() + ";"
    }

    fun print() {
        print(this.toString())
    }

    fun p(): Double {
        val side1 = sqrt((a!!.x - b!!.x) * (a!!.x - b!!.x) + (a!!.y - b!!.y) * (a!!.y - b!!.y))
        val side2 = sqrt((b!!.x - c!!.x) * (b!!.x - c!!.x) + (b!!.y - c!!.y) * (b!!.y - c!!.y))
        val side3 = sqrt((a!!.x - c!!.x) * (a!!.x - c!!.x) + (a!!.y - c!!.y) * (a!!.y - c!!.y))
        return side1 + side2 + side3
    }

    fun s(): Double {
        val side1 = sqrt((a!!.x - b!!.x) * (a!!.x - b!!.x) + (a!!.y - b!!.y) * (a!!.y - b!!.y))
        val side2 = sqrt((b!!.x - c!!.x) * (b!!.x - c!!.x) + (b!!.y - c!!.y) * (b!!.y - c!!.y))
        val side3 = sqrt((a!!.x - c!!.x) * (a!!.x - c!!.x) + (a!!.y - c!!.y) * (a!!.y - c!!.y))
        val semiP = (side1 + side2+ side3)/2
        return sqrt(semiP*(semiP-side1)*(semiP-side2)*(semiP-side3))
    }

    fun setA(x: Double, y: Double) {
        val p = Point(x, y)
        if (!p.collinear(b, c)) {
            a = p
        } else {
            println("It is not allowed to change")
        }
    }

    fun setB(x: Double, y: Double) {
        val p = Point(x, y)
        if (!p.collinear(a, c)) {
            b = p
        } else {
            println("It is not allowed to change")
        }
    }

    fun setC(x: Double, y: Double) {
        val p = Point(x, y)
        if (!p.collinear(a, b)) {
            c = p
        } else {
            println("It is not allowed to change")
        }
    }

    fun rotate(deg: Double) {
        val newAx = a!!.x * cos(deg * Math.PI / 180) - a!!.y * sin(deg * Math.PI / 180)
        val newAy = a!!.x * sin(deg * Math.PI / 180) - a!!.y * cos(deg * Math.PI / 180)
        val newBx = b!!.x * cos(deg * Math.PI / 180) - b!!.y * sin(deg * Math.PI / 180)
        val newBy = b!!.x * sin(deg * Math.PI / 180) - b!!.y * cos(deg * Math.PI / 180)
        val newCx = c!!.x * cos(deg * Math.PI / 180) - c!!.y * sin(deg * Math.PI / 180)
        val newCy = c!!.x * sin(deg * Math.PI / 180) - c!!.y * cos(deg * Math.PI / 180)
        a!!.x = newAx
        a!!.y = newAy
        b!!.x = newBx
        b!!.y = newBy
        c!!.x = newCx
        c!!.y = newCy
    }
}
