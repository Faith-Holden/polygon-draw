package solution;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;

public class DrawPolygon extends Application{
    Canvas canvas = new Canvas(400,400);
    double[] xVertices = new double[0];
    double[] yVertices = new double[0];
    boolean drawingComplete = false;
    int sideCounter;

    public void start(Stage stage) throws Exception{
        BorderPane root = new BorderPane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);

        canvas.setOnMousePressed(evt->{
            mouseClick(evt);
            draw();
        });

        draw();
        stage.show();
    }

    private void mouseClick (MouseEvent evt){
        double[] newXVertexArray = new double[xVertices.length+1];
        System.arraycopy(xVertices,0,newXVertexArray,0, xVertices.length);
        newXVertexArray[newXVertexArray.length-1] = evt.getX();
        xVertices = newXVertexArray;

        double[] newYVertexArray = new double[yVertices.length+1];
        System.arraycopy(yVertices,0,newYVertexArray,0, yVertices.length);
        newYVertexArray[newYVertexArray.length-1] = evt.getY();
        yVertices = newYVertexArray;

        //if click is within 10 px of origin, sets drawing complete to true, allowing for polygon fill in the draw function
        if(-10<xVertices[0]-xVertices[xVertices.length-1] && xVertices[0]-xVertices[xVertices.length-1]<10
                && -10<yVertices[0]-yVertices[yVertices.length-1] && yVertices[0]-yVertices[yVertices.length-1]<10&&
        xVertices.length>1){
            xVertices[xVertices.length-1]=xVertices[0];
            yVertices[xVertices.length-1]=yVertices[0];
            drawingComplete = true;
        }
        sideCounter++;

    }


    public void draw(){
        GraphicsContext graphicsContext = canvas.getGraphicsContext2D();
        graphicsContext.setFill(Color.WHITE);
        graphicsContext.fillRect(0,0,canvas.getWidth(),canvas.getHeight());
        graphicsContext.setStroke(Color.BLACK);
        graphicsContext.setFill(Color.RED);

        if(drawingComplete){
            graphicsContext.fillPolygon(xVertices,yVertices,sideCounter);
            graphicsContext.strokePolygon(xVertices,yVertices,sideCounter);
            xVertices = new double[0];
            yVertices = new double[0];
            drawingComplete = false;
            sideCounter = 0;
        }else{
            for(int i = 0; i<xVertices.length-1; i++){
                graphicsContext.strokeLine(xVertices[i],yVertices[i],xVertices[i+1],yVertices[i+1]);
            }
        }
    }

    public static void main(String[]Args){
        launch(Args);
    }

}
