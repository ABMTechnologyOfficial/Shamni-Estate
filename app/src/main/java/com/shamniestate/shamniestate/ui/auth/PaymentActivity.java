package com.shamniestate.shamniestate.ui.auth;

import static com.shamniestate.shamniestate.RetrofitApis.BaseUrls.AUTHORIZATION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import com.shamniestate.shamniestate.R;
import com.shamniestate.shamniestate.RetrofitApis.ApiInterface;
import com.shamniestate.shamniestate.RetrofitApis.RetrofitClient;
import com.shamniestate.shamniestate.databinding.ActivityPaymentBinding;
import com.shamniestate.shamniestate.models.SignupModel;
import com.shamniestate.shamniestate.models.UtilModel;
import com.shamniestate.shamniestate.utils.ProgressDialog;
import com.shamniestate.shamniestate.utils.Session;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PaymentActivity extends AppCompatActivity implements PaymentResultListener {


    private UtilModel model ;
    String selectedWorkType = "";
    String password = "" , ref_code = "";
    PaymentActivity activity ;
    private ActivityPaymentBinding binding ;
    ProgressDialog progressDialog;
    private Session session ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPaymentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        activity = PaymentActivity.this;
        session = new Session(activity);

        progressDialog = new ProgressDialog(activity);
        progressDialog.show();

        model = (UtilModel) getIntent().getSerializableExtra("data");
        selectedWorkType = getIntent().getStringExtra("workType");
        password = getIntent().getStringExtra("pass");
        ref_code = getIntent().getStringExtra("ref_code");

        makePayment();
    }


    private void makePayment() {

       // int amount = Math.round(Float.parseFloat(price) * 100);

        // initialize Razorpay account.
        Checkout checkout = new Checkout();

        checkout.setKeyID("rzp_test_W7bnxjP4xqCYzS");

        checkout.setImage(R.drawable.logo);

        JSONObject object = new JSONObject();
        try {
            object.put("name", "Shamni Estate");
            object.put("description", "Premium Associate Account Creation ");
            object.put("currency", "INR");
            object.put("amount", 100);
            object.put("prefill.contact", model.getAssociateMobile());
            object.put("prefill.email", model.getAssociateEmail());
            checkout.open(PaymentActivity.this, object);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


    private  void addData(ProgressDialog progressDialog){
        ApiInterface apiInterface = RetrofitClient.getClient(activity);
        apiInterface.signup(
                AUTHORIZATION,
                session.getAccessToken(),
                session.getUserId(),
                model.getAccountType(),
                model.getAssociateName(),
                model.getAssociateDob(),
                model.getAssociateMobile(),
                model.getAssociateAddress(),
                model.getAssociateCity(),
                model.getAssociateState(),
                model.getAssociateCityZip(),
                model.getAssociateAadharCardNo(),
                model.getAssociatePanNo(),
                model.getAssociateBankName(),
                model.getAssociateAccNo(),
                model.getAssociateBnkIfscNo(),
                model.getAssociateBnkAccName(),
                model.getAssociateEmail(),
                password,
                password,
                "1",
                model.getAssociateReraRegNo(),
                model.getAssociateAadharCardFront(),
                model.getAssociateAadharCardBack(),
                model.getAssociateBlankCheque(),
                model.getAssociatePanCardFront()
        ).enqueue(new Callback<SignupModel>() {
            @Override
            public void onResponse(@NonNull Call<SignupModel> call, @NonNull Response<SignupModel> response) {
                progressDialog.dismiss();

                if (response.code() == 200)
                    if (response.body() != null) {
                        Toast.makeText(activity, "Your Account Created..! ", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(activity,LoginActivity.class)
                                .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                                .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                        Toast.makeText(activity, "Your Account Created..! ", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(activity, "Failed..", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<SignupModel> call, @NonNull Throwable t) {

                Log.e("TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }
        });

    }

    @Override
    public void onPaymentSuccess(String s) {
        progressDialog.dismiss();
        binding.successAnimation.setVisibility(View.VISIBLE);
        Toast.makeText(activity, "Payment Success", Toast.LENGTH_SHORT).show();
        ProgressDialog progressDialog = new ProgressDialog(activity);
        addData(progressDialog);
    }

    @Override
    public void onPaymentError(int i, String s) {
        progressDialog.dismiss();
        binding.errorAnimation.setVisibility(View.VISIBLE);
        Toast.makeText(activity, "Payment Failed", Toast.LENGTH_SHORT).show();
    }
}