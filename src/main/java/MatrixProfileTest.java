
import org.javatuples.Pair;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.api.ndarray.BaseNDArray;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.indexing.NDArrayIndex;
import io.github.ensozos.core.*;


public class MatrixProfileTest {

    public static void main(String args[]) {
        MatrixProfile matrixProfile = new MatrixProfile();
  
        int window = 4;
        INDArray target2 = Nd4j.create(new double[]{0.0, 6.0, -1.0, 2.0, 3.0, 1.0, 4.0, 5.0}, new int[]{1, 8});
        System.err.println(target2.shapeDescriptor());
        INDArray query = target2.get(NDArrayIndex.point(0), NDArrayIndex.interval(1, 7));

        INDArray target = Nd4j.create(new double[]{0.0, 6.0, -1.0, 2.0, 3.0, 1.0, 4.0, 5.0}, new int[]{1, 8});
        //INDArray query = Nd4j.create(new double[]{1.0, 2.0, 0.0, 0.0, -1, 0.0, 0.0}, new int[]{1, 7});

        Pair<INDArray, INDArray> tspair = matrixProfile.stmp(target, window);
        System.err.println(tspair.getValue0());
        System.err.println(tspair.getValue1());
    }
}
