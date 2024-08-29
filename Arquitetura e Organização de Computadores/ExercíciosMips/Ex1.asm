.data
	idadeHomem1: .byte 0
	idadeHomem2: .byte 0
	idadeMulher1: .byte 0
	idadeMulher2: .byte 0
.text
	main:
		li $v0, 5
		syscall 
		addi $t0, $v0, 0
		sb $t0, idadeHomem1
		
		li $v0, 5
		syscall 
		addi $t1, $v0, 0
		sb $t1, idadeHomem2
	
		li $v0, 5
		syscall 
		addi $t2, $v0, 0
		sb $t2, idadeMulher1
		
		li $v0, 5
		syscall 
		addi $t3, $v0, 0
		sb $t3, idadeMulher2	
		
		lb $t4, idadeHomem1
		lb $t5, idadeHomem2
		
		lb $t6, idadeMulher1
		lb $t7, idadeMulher2
		
		bge $t4, $t5, homemMaisVelho
		move $t8, $t4
		move $t9, $t5
		j compararMulheres
		
	homemMaisVelho:
		move $t8, $t5
		move $t9, $t4
		
	compararMulheres:
		bge $t6, $t7, mulherMaisVelha
		move $t0, $t6
		move $t1, $t7
		j calcular
		
	mulherMaisVelha:
		move $t0, $t7
		move $t1, $t6
		
	calcular:
		add $t2, $t9, $t0
		
		mul $t3, $t8, $t1
		
		li $v0, 1
		move $a0, $t2
		syscall
		
		li $v0, 1
		move $a0, $t3
		syscall
		
		li $v0, 10
	        syscall
			