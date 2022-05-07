package com.backend.bandtito.utils;

public class YearsOfExperienceRequestBody {

        private String numberOfYears;
        private String musician;
        private String instrument;
    
        //Getters
    
        public int getNumberOfYears(){
            return Integer.parseInt(this.numberOfYears);
        }
    
        public String getMusician(){
            return this.musician;
        }
    
        public String getInstument(){
            return this.instrument;
        }

}
