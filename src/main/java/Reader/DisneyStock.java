package Reader;

import java.util.ArrayList;

public class DisneyStock {

    public String date;
    public float beta;
    public float total_debt;
    public float shares_outstanding;
    public float change_in_NCWC; //change in non-cash working capital
    public float cap_exp; //capital expenditures
    public float int_expense; //interest expenses
    public float EBIT;
    public float op_inc; //operational income
    public float ev_year_cash_flow; //EV to firm's average previous 12 months cash flow (value of firm)
    public float EBITDA;
    public float r_squared;
    public float op_expense; //operating expenses (EBIT (/operating income))
    public float rev_val; //revenue value
    public float NCWV; //non-cash working value
    public float tot_liab; //total liabilities
    public float mkt_cap; //current market capital
    public float net_income;
    public float volatility; //stock price volatility
    public float EPS;
    public float BEST_EPS;
    public boolean estimate;//compare Bloomberg Estimate of EPS with actual EPS
                                // (overestimate vs underestimate)

    public DisneyStock(String d, float b, float td, float so, float c_ncwc, float ce, float ie, float ebit, float oi, float evcf, float ebitda, float r, float oe, float rv, float ncwv, float tl, float mc, float ni, float v, float eps, float best_eps) {

        date = d;
        beta = b;
        total_debt = td;
        shares_outstanding = so;
        change_in_NCWC = c_ncwc;
        cap_exp = ce;
        int_expense = ie;
        EBIT = ebit;
        op_inc = oi;
        ev_year_cash_flow = evcf;
        EBITDA = ebitda;
        r_squared = r;
        op_expense = oe;
        rev_val = rv;
        NCWV = ncwv;
        tot_liab = tl;
        mkt_cap = mc;
        net_income = ni;
        volatility = v;
        EPS = eps;
        BEST_EPS = best_eps;

        if (EPS == BEST_EPS) {
            estimate = true;
        }
        else if (Math.abs(EPS - BEST_EPS) <= 0.05){
            estimate = false;
        }
        else {
            estimate = false;
        }
    }

    public void initializeDisney() {

        ArrayList data = new ArrayList();

        data.add(date);
        data.add(beta);
        data.add(total_debt);
        data.add(shares_outstanding);
        data.add(change_in_NCWC);
        data.add(cap_exp);
        data.add(int_expense);
        data.add(EBIT);
        data.add(op_inc);
        data.add(ev_year_cash_flow);
        data.add(EBITDA);
        data.add(r_squared);
        data.add(op_expense);
        data.add(rev_val);
        data.add(NCWV);
        data.add(tot_liab);
        data.add(mkt_cap);
        data.add(net_income);
        data.add(volatility);
        data.add(EPS);
        data.add(BEST_EPS);
        data.add(estimate);

        System.out.println(data);

    }
}
