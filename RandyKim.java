import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool

public class RandyKim implements Polygon{
    private ArrayList <Point2D.Double> myPolygon=new ArrayList<Point2D.Double>();
    SketchPad paper = new SketchPad(500, 500);
    DrawingTool pencil = new DrawingTool(paper);
    // constructors
    public String getName()
    {
        return "Randy Kim";
    }
    public Randy() {
    }

    // public methods
    public void add(Point2D.Double aPoint) { 
        myPolygon.add(aPoint);
    }

    public void draw() {
        for(Point2D.Double p: myPolygon){
            pencil.move(p.getX(),p.getY());

        }
        pencil.move(myPolygon.get(0).getX(),myPolygon.get(0).getY());
    }

    public double perimeter() {
        double perimeter = 0;
        double firstDistance = ((Point2D.Double)myPolygon.get(myPolygon.size()-1)).distance((Point2D.Double)myPolygon.get(0));

        for(int i=0; i<myPolygon.size()-1;i++){
            perimeter += ((Point2D.Double)myPolygon.get(i)).distance((Point2D.Double)myPolygon.get(i + 1));
        }
        perimeter += firstDistance;
        System.out.println("The perimeter of this polygon is " + perimeter + ".");
        return perimeter;
    }

    public double area()
    {
        double total=0;
        double a =(myPolygon.get(myPolygon.size()-1).getX());
        double b =(myPolygon.get(myPolygon.size()-1).getY());
        double c =(myPolygon.get(0).getX());
        double d =(myPolygon.get(0).getY());
        double firstArea = Math.abs(a * d - b * c);
        for(int i = 0; i < myPolygon.size()-1; i++)
        {
            double X1 = (myPolygon.get(i).getX());
            double Y1 = (myPolygon.get(i).getY());
            double X2 = (myPolygon.get(i + 1).getX());
            double Y2 = (myPolygon.get(i + 1).getY());
            total += Math.abs(X1 * Y2 - Y1 * X2);
        }
        total += firstArea;
        System.out.println("The area of this polygon is " + 0.5 * total + ".");
        return Math.abs(0.5 * total);
    }

    public static void main(){
        IrregularPolygon poly = new IrregularPolygon();
        poly.add(new Point2D.Double(20.0,10.0));
        poly.add(new Point2D.Double(70.0, 20.0));
        poly.add(new Point2D.Double(50.0,50.0));
        poly.add(new Point2D.Double(0.0,40.0));
        poly.draw();
        poly.perimeter();
        poly.area();
    }
}