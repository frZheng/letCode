//web https://leetcode-cn.com/problems/zigzag-conversion


import java.util.ArrayList;
import java.util.List;

// https://blog.csdn.net/u014421970/article/details/99881578
public class SpatialRelationUtil {
//    private static class Solution {
//
//        public Solution() {
//        }
//
//
//    }
    private static class Point {

        public double x;
        public double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }


        /**
     * 返回一个点是否在一个多边形区域内
     *
     * @param mPoints 多边形坐标点列表
     * @param point 待判断点
     * @return true 多边形包含这个点,false 多边形未包含这个点。
     */
    public static boolean isPolygonContainsPoint(List<Point> mPoints, Point point) {
        int nCross = 0;
        for (int i = 0; i < mPoints.size(); i++) {
            Point p1 = mPoints.get(i);
            Point p2 = mPoints.get((i + 1) % mPoints.size());
            // 取多边形任意一个边,做点point的水平延长线,求解与当前边的交点个数
            // p1p2是水平线段,要么没有交点,要么有无限个交点
            if (p1.y == p2.y) continue;
            // point 在p1p2 底部 --> 无交点
            if (point.y < Math.min(p1.y, p2.y)) continue;
            // point 在p1p2 顶部 --> 无交点
            if (point.y >= Math.max(p1.y, p2.y)) continue;
            // 求解 point点水平线与当前p1p2边的交点的 X 坐标 通过前面几个if条件筛选,这里的如果求出来有交点一定在p1p2连接线上,而不是延长线上.
            double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
            if (x > point.x) // 当x=point.x时,说明point在p1p2线段上
                nCross++; // 只统计单边交点
        }
        // 单边交点为偶数，点在多边形之外 ---
        return (nCross % 2 == 1);
    }

    /**
     * 返回一个点是否在一个多边形边界上
     *
     * @param mPoints 多边形坐标点列表
     * @param point 待判断点
     * @return true 点在多边形边上,false 点不在多边形边上。
     */
    public static boolean isPointInPolygonBoundary(List<Point> mPoints, Point point) {
        for (int i = 0; i < mPoints.size(); i++) {
            Point p1 = mPoints.get(i);
            Point p2 = mPoints.get((i + 1) % mPoints.size());
            // 取多边形任意一个边,做点point的水平延长线,求解与当前边的交点个数

            // point 在p1p2 底部 --> 无交点
            if (point.y < Math.min(p1.y, p2.y)) continue;
            // point 在p1p2 顶部 --> 无交点
            if (point.y > Math.max(p1.y, p2.y)) continue;

            // p1p2是水平线段,要么没有交点,要么有无限个交点
            if (p1.y == p2.y) {
                double minX = Math.min(p1.x, p2.x);
                double maxX = Math.max(p1.x, p2.x);
                // point在水平线段p1p2上,直接return true
                if ((point.y == p1.y) && (point.x >= minX && point.x <= maxX)) {
                    return true;
                }
            } else { // 求解交点
                double x = (point.y - p1.y) * (p2.x - p1.x) / (p2.y - p1.y) + p1.x;
                if (x == point.x) // 当x=point.x时,说明point在p1p2线段上
                    return true;
            }
        }
        return false;
    }


    public static void main(String[] Args) {
        SpatialRelationUtil solution = new SpatialRelationUtil();
        List<Point> mPoints = new ArrayList<>();
        double[][] edgePoints = {
                {0,0},
                {2,0},
                {0,3},
                {3,3},
        };
        for (double[] edgePoint : edgePoints) {
            mPoints.add(new Point(edgePoint[0], edgePoint[1]));
        }
        // 最后一个维度,0区域外,1区域内,2边界
        double[][] testPoints = {
                {0, 1, 2},
                {0, 0, 2},
                {1, 1, 1},
                {4, 5, 0},
        };

        boolean polygonContainsPoint;
        for (double[] testPoint : testPoints) {
            polygonContainsPoint = solution.isPolygonContainsPoint(mPoints, new Point(testPoint[0], testPoint[1]));
            if (polygonContainsPoint)
                System.out.println("in  " + testPoint[2]);
            else
                System.out.println("out " + testPoint[2]);
        }
//        boolean polygonContainsPoint = solution.isPolygonContainsPoint(mPoints, new Point(0, 1));
//        System.out.println(polygonContainsPoint);
//        polygonContainsPoint = solution.isPolygonContainsPoint(mPoints, new Point(0, 0));
//        System.out.println(polygonContainsPoint);
//        polygonContainsPoint = solution.isPolygonContainsPoint(mPoints, new Point(1, 1));
//        System.out.println(polygonContainsPoint);
//
//        polygonContainsPoint = solution.isPolygonContainsPoint(mPoints, new Point(2, 1));
//        System.out.println(polygonContainsPoint);


    }
}
