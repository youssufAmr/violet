package jonamatoka.violet.util.Statisticsnewversion;

import java.util.ArrayList;

public class Max extends Operation{

    Max(IStatistic statistic){super(statistic); }

    @Override
    public double calc() {

        double max=0,ind=0;
        for(double i:statistic.calc()) {
            if(ind==0){
                max=i;
                ++ind;
                continue;
            }
            if(i>max)
                max=i;
        }

        return max;

    }

}
