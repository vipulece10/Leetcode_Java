class Solution {
    public class Car{
        int position;
        double time;
        
        public Car(int position,double time){
            this.position = position;
            this.time = time;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        if(position.length < 2)
            return position.length;
        
        Car [] cars = new Car[position.length];
        for(int i =0;i< position.length;i++){
            double time = (double) (target - position[i]) / (double)speed[i];
            cars[i] = new Car(position[i],time);
        }
        Arrays.sort(cars,new Comparator<Car>(){
            @Override
            public int compare(Car car1,Car car2){
                return car2.position - car1.position;
            }
        });
        
       
        double prev = cars[0].time;
        int count = 1;
        for(int i =1;i< position.length;i++){
            double curr = cars[i].time;
            if(curr > prev){
                count++;
                prev = curr;
            }
        }
        return count;
    }
}