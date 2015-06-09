package com.example.RentCalculator;

public class Property {

    // Private Variables
    int _id;
    String _address;
    double _purchasePrice;
    int _term;
    double _interest;
    double _downPayment;

    // Empty Constructor

    public Property(){

    }

    // Constructor
    public Property(int id, String address, double purchasePrice, int term,
                    double interest, double downPayment){
        this._id = id;
        this._address = address;
        this._purchasePrice = purchasePrice;
        this._term = term;
        this._interest = interest;
        this._downPayment = downPayment;
    }

    // Constructor
    public Property(String address, double purchasePrice, int term,
                    double interest, double downPayment){
        this._address = address;
        this._purchasePrice = purchasePrice;
        this._term = term;
        this._interest = interest;
        this._downPayment = downPayment;
    }

    // ID
    public int get_id(){
        return this._id;
    }

    public void set_id(int _id){
        this._id = _id;
    }

    public String get_address() {
        return _address;
    }

    public void set_address(String _address) {
        this._address = _address;
    }

    public double get_purchasePrice() {
        return _purchasePrice;
    }

    public void set_purchasePrice(double _purchasePrice) {
        this._purchasePrice = _purchasePrice;
    }

    public int get_term() {
        return _term;
    }

    public void set_term(int _term) {
        this._term = _term;
    }

    public double get_interest() {
        return _interest;
    }

    public void set_interest(double _interest) {
        this._interest = _interest;
    }

    public double get_downPayment() {
        return _downPayment;
    }

    public void set_downPayment(double _downPayment) {
        this._downPayment = _downPayment;
    }

/**
    // User Inputs
    EditText _purchasePrice =
            (EditText) findViewById(R.id.inputPurchasePrice);
    EditText _term = (EditText) findViewById(R.id.inputTerm);
    EditText _interest = (EditText) findViewById(R.id.inputInterest);
    EditText _downPayment= (EditText) findViewById(R.id.inputDownPayment);

    // Outputs
    TextView _monthlyRent =
            (TextView) findViewById(R.id.outputMonthlyPayment);

    Double purchasePrice, interest, monthlyRent, downPayment;
    Integer term;

    purchasePrice = Double.parseDouble(_purchasePrice.getText().toString());
    term = Integer.parseInt(_term.getText().toString());
    // Converts APR to Monthly Rate
    interest = Double.parseDouble(_interest.getText().toString()) / 1200;
    downPayment = Double.parseDouble(_downPayment.getText().toString());

    // Calculate Total Loan Amount
    purchasePrice -= downPayment;

    // Calculate Monthly Rent
    monthlyRent = purchasePrice *
            (interest * Math.pow(1 + interest, term)) /
            (Math.pow(1 + interest, term) - 1);

    //Converts variables to 2 Decimal Places
    DecimalFormat df = new DecimalFormat("#.##");

    // Output Monthly Rent
    _monthlyRent.setText("$" + df.format(monthlyRent));
    */
}
