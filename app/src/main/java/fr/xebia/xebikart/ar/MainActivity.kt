package fr.xebia.xebikart.ar

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.sceneform.Node
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.ux.ArFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var andyRenderable: ModelRenderable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ModelRenderable.builder().setSource(this, R.raw.arch_ballon).build()
            .thenAccept { renderable ->
                andyRenderable = renderable

                val node = Node()
                node.setParent((ux_fragment as ArFragment).arSceneView.scene)
                node.renderable = andyRenderable
            }.exceptionally { throwable ->
            Log.e("ARFragment", "Unable to load Renderable.", throwable)
            null
        }
    }

}
