class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int n = students.length;
        int result = n;

        int[] studentsCount = new int[2];

        for(int i=0; i<n; i++){
            studentsCount[students[i]]++;
        }

        for(int i =0; i<n; i++){

            if(studentsCount[sandwiches[i]] != 0){
                result--;
                studentsCount[sandwiches[i]]--;
            }
            else{
                break;
            }
        }

        return result;
    }
}