package org.example.aop.C01AopLean.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Info implements Serializable {
	private static final long serialVersionUID = -1L;
	private String title;
	private String content;
}
