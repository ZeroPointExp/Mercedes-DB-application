package custom_view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View
import com.example.mercedes_db_ui.R


class RegistrationCustomView(context: Context,
                             attributeSet: AttributeSet?,
                             defStyleAttr : Int,
                             defStyleRes : Int
) : View(context, attributeSet, defStyleAttr, defStyleRes){

    constructor(context: Context, attributeSet: AttributeSet?, defStyleAttr: Int ) : this (context, attributeSet, defStyleAttr, 0)
    constructor(context: Context, attributeSet: AttributeSet?) : this (context, attributeSet, 0)
    constructor(context: Context) : this(context, null)

    private lateinit var p : Paint
    private lateinit var p_two : Paint
    private lateinit var direction : String
    private lateinit var path : Path

    init {
        if (attributeSet != null) {
            path = Path()
            p = Paint()
            p_two = Paint()
            initAttributes(attributeSet, defStyleAttr, defStyleRes)
            p.strokeWidth = 10f
        }
    }

    private fun initAttributes(attributeSet: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) {
        if (attributeSet != null) {
            val typedArray = context.obtainStyledAttributes(attributeSet,R.styleable.RegistrationCustomView)
            direction = typedArray.getString(R.styleable.RegistrationCustomView_direction).toString()
            p.color = typedArray.getColor(R.styleable.RegistrationCustomView_color, Color.BLACK)
            p_two.color = typedArray.getColor(R.styleable.RegistrationCustomView_line_color, Color.WHITE)
            typedArray.recycle()
        }
    }

    override fun onDraw(canvas: Canvas?) {
        if(direction == "left"){
            //path = Path()
            path.moveTo(0f, height.toFloat())
            path.lineTo(width.toFloat(),(height/ 1.3).toFloat())
            path.lineTo(width.toFloat(), height.toFloat())

            canvas?.drawPath(path, p)

            p_two.strokeWidth = 5f

            canvas?.drawLine(width.toFloat(), 0f, width.toFloat() ,(height / 1.3 + 4 ).toFloat(), p_two)
            canvas?.drawLine(width.toFloat(), (height / 1.3 + 4 ).toFloat(), 0f , height.toFloat(), p_two)
            super.onDraw(canvas)
        }

        if(direction == "right"){
           // path = Path()
            path.moveTo(width.toFloat(), height.toFloat())
            path.lineTo(0f,(height/ 1.3).toFloat())
            path.lineTo(0f, height.toFloat())

            canvas?.drawPath(path, p)

            p_two.strokeWidth = 5f

            canvas?.drawLine(0f, 0f, 0f ,(height / 1.3 + 4).toFloat(), p_two)
            canvas?.drawLine(0f, (height / 1.3 + 4 ).toFloat(), width.toFloat(), height.toFloat(), p_two)
            super.onDraw(canvas)
        }
        }
    }
