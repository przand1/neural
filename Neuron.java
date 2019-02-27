public class Neuron {
  private double[] weights;

  public double computeY(double[] inputs) {
    if (inputs.length == weights.length) {
      double y = 0;
      for (int i = 0; i < inputs.length ; i++ ) {
        y += (inputs[i] * weights[i]);
      }
      return y<0 ? 0 : 1;
    }
    else return -1;
  }

  public Neuron(double[] weights) {
    setWeights(weights);
  }
  public void setWeights(double[] weights) {
    this.weights = weights;
  }
  public double[] getWeights() {
    return weights;
  }
}
