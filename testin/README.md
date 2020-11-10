
Section 0:
	TABLE OF BENCHMARKS


Section 1: Setting up environment

Datadriven using conda:
conda create -n CS_methods_environement python=3.7.9
conda activate CS_methods_environement

conda install pytorch==1.6.0 torchvision cudatoolkit=10.2 -c pytorch
conda install scipy==1.5.2
conda install opencv==3.4.2
conda install scikit-image==0.17.2
conda install tensorflow-gpu==1.15
 
Matlab:





Section 2: Parameters

sensing: Method of sensing
reconstruction: Method of reconstruction
stage: Training or testing
default: [True] use original paper's parameters [False] manually set parameters
dataset: Dataset to be used
input_channel: # of channels training/testing images have
input_width: Width of training/testing images
input_height: Height of training/testing images
m: # of measurements/outputs of sensing matrix
n: # of inputs to sensing matrix
specifics: Specific parameter settings of chosen reconstruction method




Section 3: List of Methods
Model-based:
TVAL3
(Reference: https://www.caam.rice.edu/~zhang/reports/tr1213.pdf)
(Repository: https://www.caam.rice.edu/~optimization/L1/TVAL3/)
	-list main (we choose specific dataset and specific cs ratio) benchmark results
	
	IF THERE IS NO DIFFERENCE IN RESULTS, SKIP THESE TWO POINTS
	-compare to one in original paper
	-significant modifications that we made to the code that affect the performance
NLR-CS
(Reference: https://see.xidian.edu.cn/faculty/wsdong/Papers/Journal/NLR-CS-TIP.pdf)
(Repository: http://see.xidian.edu.cn/faculty/wsdong/Code_release/NLR_codes.rar)
	-list main (we choose specific dataset and specific cs ratio) benchmark results
	
	IF THERE IS NO DIFFERENCE IN RESULTS, SKIP THESE TWO POINTS
	-compare to one in original paper
	-significant modifications that we made to the code that affect the performance
D-AMP
(Reference: https://arxiv.org/pdf/1406.4175.pdf)
(Repository: https://github.com/ricedsp/D-AMP_Toolbox)
	-list main (we choose specific dataset and specific cs ratio) benchmark results
	
	IF THERE IS NO DIFFERENCE IN RESULTS, SKIP THESE TWO POINTS
	-compare to one in original paper
	-significant modifications that we made to the code that affect the performance
L1
(Reference: https://statweb.stanford.edu/~candes/software/l1magic/)
(Repository: https://statweb.stanford.edu/~candes/software/l1magic/)
	-list main (we choose specific dataset and specific cs ratio) benchmark results
	
	IF THERE IS NO DIFFERENCE IN RESULTS, SKIP THESE TWO POINTS
	-compare to one in original paper
	-significant modifications that we made to the code that affect the performance


Datadriven:
ISTANET 
(Reference: https://openaccess.thecvf.com/content_cvpr_2018/papers_backup/Zhang_ISTA-Net_Interpretable_Optimization-Inspired_CVPR_2018_paper.pdf)
(Repository: https://github.com/jianzhangcs/ISTA-Net)
	-list main (we choose specific dataset and specific cs ratio) benchmark results
	
	-compare to one in original paper
	-merged ISTANet and ISTANetPlus, parameter used to control which one to train/test
	
LDAMP
(Reference: https://papers.nips.cc/paper/2017/file/8597a6cfa74defcbde3047c891d78f90-Paper.pdf)
(Repository: https://github.com/ricedsp/D-AMP_Toolbox/tree/master/LDAMP_TensorFlow)
	-list main (we choose specific dataset and specific cs ratio) benchmark results
	
	-compare to one in original paper
	-only supports layer-by-layer and denoiser-by-denoiser training (not end-to-end)
	-supports gaussian, complex-gaussian, and coded-diffraction sensing for Layer-by-Layer (not Fast-JL)
	
ReconNet
(Reference: https://openaccess.thecvf.com/content_cvpr_2016/papers/Kulkarni_ReconNet_Non-Iterative_Reconstruction_CVPR_2016_paper.pdf)
(Repository: https://github.com/KuldeepKulkarni/ReconNet)
	-list main (we choose specific dataset and specific cs ratio) benchmark results
	
	IF THERE IS NO DIFFERENCE IN RESULTS, SKIP THESE TWO POINTS
	-compare to one in original paper
	-significant modifications that we made to the code that affect the performance
LAPRAN
(Reference: https://openaccess.thecvf.com/content_ECCV_2018/papers/Kai_Xu_LAPCSRA_Deep_Laplacian_ECCV_2018_paper.pdf)
(Repository: https://github.com/PSCLab-ASU/LAPRAN-PyTorch)
	-list main (we choose specific dataset and specific cs ratio) benchmark results
	
	IF THERE IS NO DIFFERENCE IN RESULTS, SKIP THESE TWO POINTS
	-compare to one in original paper
	-significant modifications that we made to the code that affect the performance
CSGM
(Reference: http://proceedings.mlr.press/v70/bora17a/bora17a.pdf)
(Repository: https://github.com/AshishBora/csgm)
	-list main (we choose specific dataset and specific cs ratio) benchmark results
	
	IF THERE IS NO DIFFERENCE IN RESULTS, SKIP THESE TWO POINTS
	-compare to one in original paper
	-significant modifications that we made to the code that affect the performance
CSGAN
(Reference: http://proceedings.mlr.press/v97/wu19d/wu19d.pdf)
(Repository: https://github.com/deepmind/deepmind-research/tree/master/cs_gan)
	-list main (we choose specific dataset and specific cs ratio) benchmark results
	
	IF THERE IS NO DIFFERENCE IN RESULTS, SKIP THESE TWO POINTS
	-compare to one in original paper
	-significant modifications that we made to the code that affect the performance