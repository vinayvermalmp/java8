package com.vin.java17nf.assignment;

public final record LecturerRecord(String name, int age, Faculty faculty, Department dep) {

    public LecturerRecord {
        if (name.isBlank() || age < 0) {
            String errorMsg = """
                    Illegal argument Exception
                    "name" : %s
                    "age" : %s
                    """.formatted(name, age);
            throw new IllegalArgumentException(errorMsg);
        }
    }

    public boolean hasPhd(){
        String prefix = name.toUpperCase().substring(0, 3); // "Dr. ..."
        String suffix = name.toUpperCase().substring(name.length()-3);
        return switch(prefix){
            case "DR." -> true;
            default ->
                switch(suffix){
                case "PHD" -> true;
                    default -> false;
                 };
        };
    }

    public void whichFaculty(){
        switch(faculty){
            case EngineeringFaculty engg -> {
                System.out.println("Faculty of: " +engg);
                engg.engineering();
            }
            case HumanitiesFaculty hum -> {
                System.out.println("Faculty of: " +hum);
                hum.humanities();
            }
            case BusinessFaculty bu -> {
                System.out.println("Faculty of: " +bu);
                bu.business();
            }
            default -> {
              throw  new IllegalArgumentException("Invalid Faculty: " + faculty);
            }
        }
    }

    public void whichDept(){
        switch (dep){
            case ComputerEngineeringDept comp -> {
                System.out.println("Dept of:"+comp.toString());
                comp.compEng();
            }
            case SoftwareEngineeringDept sw -> {
                System.out.println("Dept of:" +sw.toString());
                sw.swEng();
            }
            case SocialCareDept soc -> {
                System.out.println("Dept of:" +soc.toString());
                soc.socialCare();
            }
            case AccountingDept acc -> {
                System.out.println("Dept of:" + acc.toString());
                acc.accounting();
            }
        }
    }
}
