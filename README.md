# polygon-draw
My solution for Chapter 6 Exercise 9 of “Introduction to Programming Using Java”.


NOTE: This is a javafx program. It requires the javafx library as a dependency. (See bottom of this README for javafx instructions).

Problem Description:
A polygon is a geometric figure made up of a sequence of connected line segments. The
points where the line segments meet are called the vertices of the polygon. Subsection
6.2.4 has a list of shape-drawing methods in a GraphicsContext. Among them are
methods for stroking and for filling polygons: g.strokePolygon(xcoords,ycoords,n)
and g.fillPolygon(xcoords,ycoords,n), For these commands, the coordinates of the
vertices of the polygon are stored in arrays xcoords and ycoords of type double[ ], and
the number of vertices of the polygon is given by the third parameter, n. Note that it
is OK for the sides of a polygon to cross each other, but the interior of a polygon with
self-intersections might not be exactly what you expect.
Write a program that lets the user draw polygons. As the user clicks a sequence of
points in a Canvas, count the points and store their x- and y-coordinates in two arrays.
These points will be the vertices of the polygon. As the user is creating the polygon,
you should just connect all the points with line segments. When the user clicks near the
starting point, draw the complete polygon. Draw it with a red interior and a black border.
Once the user has completed a polygon, the next click should clear the data and start a
new polygon from scratch.

Javafx setup instructions:
Download javafx from: https://gluonhq.com/products/javafx/ (I used javafx 12). Save it to a location of your choice.
Unpack the zip folder.
Open my project with your IDE of choice (I use intellij IDEA).
Add the javafx/lib folder as an external library for the project. For intellij, this means going to "project structure" -> "libraries" -> "add library" ->{javafx location}/lib
Add the following as a VM argument for the project: --module-path "{full path to your javafx/lib folder}" --add-modules javafx.controls,javafx.fxml,javafx.base,javafx.graphics,javafx.media,javafx.swing,javafx.web
Build and run the project as normal.
