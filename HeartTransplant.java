/**
 * 
 * HeartTransplant class
 * 
 * @author Ana Paula Centeno
 * @author Haolin (Daniel) Jin
 */
public class HeartTransplant {

    // patient array, each Patient is read from the data file
    private Patient[] patients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause survivabilityByCause;

    /*
     * Default constructor
     * Initializes patients to null.
     * Initializes survivabilityByAge to null.
     * Initializes survivabilityByCause to null. 
     */
    public HeartTransplant() {

        patients = null;
        survivabilityByAge = null;
        survivabilityByCause = null;
    }

    /*
     * Returns patients
     */
    public Patient[] getPatients() {

        return patients;
     } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        return survivabilityByAge;
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
        return survivabilityByCause;
    }

    /*
     * 1) Initialize the instance variable patients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
     *    File Format: 
     *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
     * 
     *    Each line refers to one Patient, all values are integers.
     * 
     */
    public void readPatients (int numberOfLines) {
        patients = new Patient[numberOfLines];
        for(int i = 0; i<patients.length; i++)
        {
            int ID = StdIn.readInt();
            int ethnicityofPerson = StdIn.readInt();
            int GenderofHuman = StdIn.readInt();
            int AgeofHuman = StdIn.readInt();
            int Cause = StdIn.readInt();
            int UrgencyLevel = StdIn.readInt();
            int HealthStatus = StdIn.readInt();
            patients[i] = new Patient(ID, ethnicityofPerson, GenderofHuman, AgeofHuman, Cause, UrgencyLevel, HealthStatus);
        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
     * 
     * 2) Reads from the command line file to populate the object. 
     *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     */
    public void readSurvivabilityByAge (int numberOfLines) {
        survivabilityByAge = new SurvivabilityByAge();
        for(int i = 0; i<numberOfLines; i++)
        {
            int AgeofHuman = StdIn.readInt();
            int YearsAfterTransplant = StdIn.readInt();
            double Rate = StdIn.readDouble();
            survivabilityByAge.addData(AgeofHuman, YearsAfterTransplant, Rate);
        }
    }

    /*
     * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
     * 
     * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an 
     *    integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     */
    public void readSurvivabilityByCause (int numberOfLines) {
        survivabilityByCause = new SurvivabilityByCause();
        for(int i = 0; i<numberOfLines; i++)
        {
            int Cause = StdIn.readInt();
            int YearsAfterTransplant = StdIn.readInt();
            double Rate = StdIn.readDouble();
            survivabilityByCause.addData(Cause, YearsAfterTransplant, Rate);
        }
    }
    
    /*
     * Returns a Patient array containing the patients, 
     * from the patients array, that have age above the parameter age.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with age above the parameter age.
     * 
     * Return null if there is no Patient with age above the 
     * parameter age.
     */ 
    public Patient[] getPatientsWithAgeAbove(int age) {
        int c = 0;
        for(Patient p : patients)
        {
            if(p.getAge()>age)
            {
                c++;
            }
        }
        if(c==0)
            return null;
        Patient[] patientAge = new Patient[c];
        int ind = 0;
        for(int i = 0; i<patients.length; i++)
        {
            if(patients[i].getAge()>age)
            {
                patientAge[ind] = patients[i];    
                ind++;
            }        
        }           
        return patientAge;
    }

    /*
     * Returns a Patient array containing the patients, from the patients array, 
     * that have the heart condition cause equal to the parameter cause.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Patient with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Patient[] getPatientsByHeartConditionCause(int cause) {

        int c = 0;
        for(Patient p : patients)
        {
            if(p.getCause()==cause)
                c++;
        }
        Patient[] heartCondition = new Patient[c];
        int ind = 0;
        for(int i = 0; i<patients.length; i++)
        {
            if(patients[i].getCause()==cause)
            {
                heartCondition[ind] = patients[i];
                ind++;
            }
        }
        if(c > 0)
            return heartCondition;
        return null;
    }

    /*
     * Returns a Patient array containing patients, from the patients array,
     * that have the state of health equal to the parameter state.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the state of health equal to the parameter state.
     * 
     * Return null if there is no Patient with the state of health 
     * equal to the parameter state.
     */ 
    public Patient[] getPatientsByUrgency(int urgency) {

        int c = 0; 
        for(Patient p : patients) 
        {
            if(p.getUrgency() == urgency)
                c++;
        }
        Patient[] HealthStatus = new Patient[c];
        int index = 0;
        for(int i = 0; i<patients.length; i++)
        {
            if(patients[i].getUrgency() == urgency)
            {
                HealthStatus[index] = patients[i];
                index++;
            }
        }
        if(c > 0)
            return HealthStatus;
	return null;
    }

    /*
     * Assume there is a heart available for transplantation surgery.
     * Also assume that the heart is of the same blood type as the
     * Patients on the patients array.
     * This method finds the Patient to be the recepient of this
     * heart.
     * 
     * The method returns a Patient from the patients array with
     * he highest potential for survivability after the transplant.
     * 
     * Assume the patient returned by this method will receive a heart,
     * therefore the Patient will no longer need a heart.
     * 
     * There is no correct solution, you may come up with any 
     * function to find the patient with the highest potential 
     * for survivability after the transplant.
     */ 
    public Patient getPatientForTransplant () {

        int it = 0;
        double highSurvival = 0;
        int ind = 0;
        for(Patient p : patients)
        {
            if(p.getNeedHeart() == true)
            {
                double surviveRateCauseofHuman = survivabilityByCause.getRate(p.getCause(), 5);
                double surviveRateAgeofHuman = survivabilityByAge.getRate(p.getAge(), 5);
                double average = (surviveRateAgeofHuman + surviveRateCauseofHuman)/2;
                if(average > highSurvival)
                {
                    highSurvival = average;
                    ind = it;
                }
            }
            it++;
        }
        patients[ind].setNeedHeart(false);
        return patients[ind];
    }
    }
