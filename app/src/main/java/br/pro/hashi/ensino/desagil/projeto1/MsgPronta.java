package br.pro.hashi.ensino.desagil.projeto1;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.widget.TextView;

public class MsgPronta {

    private TextView message;
    private boolean flag; // A flag diz se a menssagem está selecionada ou não
    private Context context;

    public MsgPronta (TextView message, Boolean flag, Context context) {
        this.message = message;
        this.flag = flag;
        this.context = context;
    }

    public TextView getMessage() {
        return message;
    }

    public void setFlagTrue() {
        flag = true;
    }

    public void setFlagFalse() {
        flag = false;
    }

    public Boolean getFlag() {
        return flag;
    }

    public String getMessageString() {
        return message.getText().toString();
    }

    public void paintMessage() {
        if (this.flag) {
            message.setTextColor(ContextCompat.getColor(context, R.color.blue));
        } else {
            message.setTextColor(ContextCompat.getColor(context, R.color.black));
        }
    }
}
