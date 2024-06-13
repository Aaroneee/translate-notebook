package org.autumn.translateNotebook;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Opt;
import net.bytebuddy.dynamic.DynamicType;
import org.apache.commons.lang3.StringUtils;
import org.autumn.translateNotebook.constant.TranslationTypeEnum;
import org.autumn.translateNotebook.entity.NoteBook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

@SpringBootTest
class TranslateNotebookApplicationTests {

	@Test
	void contextLoads() {
		NoteBook noteBook = new NoteBook();
		noteBook.setSourceText("1");
//		noteBook.setTargetText("2");
		boolean result=StringUtils.isAnyBlank(noteBook.getSourceText(), noteBook.getTargetText());
		System.out.println(result);

	}

	void test(Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
		Class<?> aClass = obj.getClass();
		System.out.println(aClass);
		System.out.println(aClass.isInstance(obj));

		Method valueOf = aClass.getMethod("valueOf");
		Object invoke = valueOf.invoke(obj);
	}

}
