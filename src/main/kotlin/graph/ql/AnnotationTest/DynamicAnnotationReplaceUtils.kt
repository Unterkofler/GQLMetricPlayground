package graph.ql.AnnotationTest

import java.lang.reflect.Field
import java.lang.reflect.Method

class DynamicAnnotationReplaceUtils(private val ANNOTATIONS: String, private val ANNOTATIONS_DATA: String) {

    public fun annotationReplacedBy(targetClazz: Class<*>, orginalName: String, newOne: Annotation) {
        try {
            @SuppressWarnings("all")
            val method: Method = targetClazz.getDeclaredMethod(ANNOTATIONS_DATA, null)
            method.trySetAccessible()

            val annotationsData: Object = method.invoke(targetClazz) as Object

            val annotations: Field = annotationsData.javaClass.getDeclaredField(ANNOTATIONS)
            annotations.trySetAccessible()

            @SuppressWarnings("unchecked")
            var map: Map<Class<out Annotation?>?, Annotation?>? =
                annotations[annotationsData] as Map<Class<out Annotation?>?, Annotation?>

            val original: Annotation? = map?.entries?.stream()?.filter { e ->
                e.key?.name.equals(orginalName)
            }?.findFirst()?.get()?.value

            if (original == null){
                throw IllegalArgumentException(String.format("Class(%s) has not %s annotaion.", targetClazz, orginalName))
            }

            //map.plus(original, newOne)
            } catch (ex: Exception){
                throw  java.lang.IllegalArgumentException(ex)
        }

    }
}